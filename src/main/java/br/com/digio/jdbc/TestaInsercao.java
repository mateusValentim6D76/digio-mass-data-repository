package br.com.digio.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.getConnection();

		Statement stm = conn.createStatement();
		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('TESTE', 'TESTE DE PRODUTO')",
				Statement.RETURN_GENERATED_KEYS);

		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("Id criado: " + id);
		}
	}
}
