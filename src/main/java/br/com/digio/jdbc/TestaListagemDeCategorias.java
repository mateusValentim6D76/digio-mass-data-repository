package br.com.digio.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.digio.dao.CategoriaDAO;
import br.com.digio.dao.ProdutoDAO;
import br.com.digio.model.Categoria;
import br.com.digio.model.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().getConnection()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
//				try {
//					for (Produto produto : new ProdutoDAO(connection).buscar(ct)) {
//						System.out.println(ct.getNome() + " - " + produto.getNome());
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
			});
		}
	}
}