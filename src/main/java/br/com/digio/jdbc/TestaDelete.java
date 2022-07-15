package br.com.digio.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaDelete {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.getConnection();

		Statement stm = conn.createStatement();
		stm.execute("DELETE FROM PRODUTO WHERE ID > 2");

		Integer linhasModificadas = stm.getUpdateCount();

		System.out.println("Linhas modificadas: " + linhasModificadas);
	}

}
