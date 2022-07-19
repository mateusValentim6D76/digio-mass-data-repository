package br.com.digio.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaDelete {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.getConnection();

		PreparedStatement stm = conn.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		
		stm.setInt(1, 2);
		stm.execute();

		Integer linhasModificadas = stm.getUpdateCount();

		System.out.println("Linhas modificadas: " + linhasModificadas);
	}

}
