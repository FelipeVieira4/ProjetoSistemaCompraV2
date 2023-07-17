package dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import produto.Categorias;
import produto.Produto;

public class CrudDados {
	
	/*
	 * Adicionar um novo produto ao banco de dados utilizando os valores de um objeto "Produto" já existente
	 * */
	public static void salvar(Produto p) {
		
		String queryCommand = "insert into produto(nome,preco,caminhoFoto,localproduzido,contatoDistribuidora,descricao,categoria) values(?,?,?,?,?,?,?)";

		ConexaoMySQL conexaoSQL = new ConexaoMySQL();
		
		try {
			PreparedStatement statement = conexaoSQL.getConexao().prepareStatement(queryCommand);
			
			statement.setString(1, p.getNome());
			statement.setFloat(2, p.getPreco());
			statement.setString(3, p.getPatchIcon());
			statement.setString(4, p.getLocalProduzido());
			statement.setString(5, p.getContatoDistribuidora());
			statement.setString(6, p.getDecricao());
			statement.setString(7, String.valueOf(p.getCategoria()));			
			
							
			statement.execute();
			
			statement.close();
		}catch(SQLException io)
		{
			io.printStackTrace();
		}

		conexaoSQL.closeConexao();

	}
	
	
	
	/*
	 * Método remover um determinado produto do banco de dados atráves do seu ID
	 * */
	public static void remove(int id) {
		String queryCommand = "delete from produto where id = ?";
		
		ConexaoMySQL conexaoSQL = new ConexaoMySQL();
			
		try {
			PreparedStatement statement = conexaoSQL.getConexao().prepareStatement(queryCommand);
			statement.setInt(1, id);
			statement.execute();
			
			statement.close();
		}catch(SQLException io) {
			io.printStackTrace();
		}
		
		
		conexaoSQL.closeConexao();
	}
	
	/*
	 * Método retornar uma Lista dos produtos do Banco de Dados com id,nome e preço dos produtos
	 * */
	public static ArrayList<Produto> buscaLista() {
				
		String queryCommand = "select * from produto";
		
		//Connection conexao = new ConexaoMySQL().conectar();

		ConexaoMySQL conexaoSQL = new ConexaoMySQL();
		
		
		ArrayList<Produto> produtoList = new ArrayList<Produto>();
		
		try {

			PreparedStatement statement = conexaoSQL.getConexao().prepareStatement(queryCommand);
			ResultSet resultStatement = statement.executeQuery();
			
			String id,nome;
			float preco;
			
			while(resultStatement.next()) {
				
				id=resultStatement.getString("id");
				nome=resultStatement.getString("nome");
				preco=Float.parseFloat(resultStatement.getString("preco"));
				
				produtoList.add(new Produto(id,nome,preco));
			}
			
			statement.close();
			resultStatement.close();
		}catch(SQLException io) {
			io.printStackTrace();
		}
		
		
		conexaoSQL.closeConexao();
		
		return produtoList;
	}
	
	/*
	 * Método retornar os valores de um determinado produto utilizando o seu ID 
	 * */
	public static Produto busca(int id) {
		
		String queryCommand = "select * from produto where id = ?";
		

		//Connection conexao = new ConexaoMySQL_descontinuado().conectar();
		ConexaoMySQL conexaoSQL = new ConexaoMySQL();
		
		Produto produto=null;
		
		try {

			PreparedStatement statement = conexaoSQL.getConexao().prepareStatement(queryCommand);
			statement.setInt(1,id);
			ResultSet resultStatement = statement.executeQuery();
			
			if(resultStatement.next()) {
				resultStatement.first(); //Seta na primeira coluna
				
				produto = new Produto();
				
				produto.setPreco(Float.parseFloat(resultStatement.getString("preco")));
				produto.setNome(resultStatement.getString("nome"));
				produto.setCodigo(resultStatement.getString("id"));
				produto.setPatchIcon(resultStatement.getString("caminhoFoto"));
				produto.setContatoDistribuidora(resultStatement.getString("contatoDistribuidora"));
				produto.setLocalProduzido(resultStatement.getString("localproduzido"));
				produto.setDecricao(resultStatement.getString("descricao"));
				produto.setCategoria(Categorias.valueOf(resultStatement.getString("categoria")));
			}
	
			
			statement.close();
			resultStatement.close();
			
		}catch(SQLException io) {
			io.printStackTrace();
		}
		
		
		conexaoSQL.closeConexao();

		return produto;
	}
	
	public static void editarProduto(Produto p,int index) {
		String queryString = 
				"update produto set "
				+"nome = ?"
				+",preco = ?"
				+" where id = ?";
		
		ConexaoMySQL conexao = new ConexaoMySQL();
		
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(queryString);
			
			statement.setString(1, p.getNome());
			statement.setFloat(2, p.getPreco());
			statement.setInt(3, index);
			
			statement.execute();
			statement.close();
		}catch(SQLException io) {
			
		}
		conexao.closeConexao();
	}
	
	
}