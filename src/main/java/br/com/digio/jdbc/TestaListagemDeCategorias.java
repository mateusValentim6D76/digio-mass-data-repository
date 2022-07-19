package br.com.digio.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.digio.dao.CategoriaDAO;
import br.com.digio.model.Categoria;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().getConnection()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.listar();
			listaDeCategorias.stream().forEach(ct -> System.out.println(ct.getNome()));
		}
	}
}
