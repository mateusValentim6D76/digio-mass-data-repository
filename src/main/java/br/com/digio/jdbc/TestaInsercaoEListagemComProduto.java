package br.com.digio.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.digio.dao.ProdutoDAO;
import br.com.digio.model.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

		
	
		
		Produto teste1 = new Produto("PRODUTO 1", "1");
		Produto teste2 = new Produto("PRODUTO 2", "2");

		{
			try (Connection connection = new ConnectionFactory().getConnection()) {
				ProdutoDAO produtoDAO = new ProdutoDAO(connection);
				new ProdutoDAO(connection).salvar(teste1);
				new ProdutoDAO(connection).salvar(teste2);

				List<Produto> listar = produtoDAO.listar();
				listar.stream().forEach(lp -> System.out.print(lp));
			}
		}
	}
}
