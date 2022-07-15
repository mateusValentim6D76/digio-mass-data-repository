package br.com.digio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/digio_mass_data?useTimezone=true&serverTimezone=UTC", "root", "root");

		Statement stm = conn.createStatement();
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

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
