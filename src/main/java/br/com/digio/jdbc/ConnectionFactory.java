package br.com.digio.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private final String jdbcConnection = "jdbc:mysql://localhost/digio_mass_data?useTimezone=true&serverTimezone=UTC";
	private DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(jdbcConnection);
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		
		this.dataSource = comboPooledDataSource;
		
	}
	
	public Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();

	}
}
