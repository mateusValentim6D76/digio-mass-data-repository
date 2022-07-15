package br.com.digio.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.getConnection();
		
		PreparedStatement stm = conn.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();

		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println("id: " + id);
			String nome = rst.getString("NOME");
			System.out.println("nome: " + nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println("descricao: " + descricao + "\n");
		}

		conn.close();
	}

}
