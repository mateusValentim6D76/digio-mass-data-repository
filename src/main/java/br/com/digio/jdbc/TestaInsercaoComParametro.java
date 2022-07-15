package br.com.digio.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		String nome = "TESTE 2'";
		String descricao = "TESTE 2); DELETE FROM Produto;";
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.getConnection();

		PreparedStatement stm = conn.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS);

		stm.setString(1, nome);
		stm.setString(2, descricao);

		System.out.println(stm);
		stm.execute();
		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("Id criado: " + id);
		}
	}
}
