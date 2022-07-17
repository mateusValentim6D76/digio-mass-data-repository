package br.com.digio.jdbc;

import java.sql.SQLException;

public class TestaPool {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory conn = new ConnectionFactory();

		for (int i = 0; i < 20; i++) {
			conn.getConnection();
			System.out.println("Conexao de numero: " + i);
		}
	}
}
