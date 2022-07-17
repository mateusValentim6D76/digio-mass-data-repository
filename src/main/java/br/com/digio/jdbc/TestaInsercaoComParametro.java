package br.com.digio.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection conn = connectionFactory.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement stm = conn.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel("Smart TV", "80 Polegadas", stm);
				adicionarVariavel("Radio", "Radio de pilha", stm);
				conn.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				conn.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
//		if(nome.equals("Radio")) {
//			throw new RuntimeException("Nao foi possivel adicionar o produto");
//		}
		System.out.println(stm);
		stm.execute();
		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("Id criado: " + id);
			}
		}
	}
}
