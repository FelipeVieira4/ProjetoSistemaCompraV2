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
			PreparedStatement state = conexaoSQL.getConexao().prepareStatement(queryCommand);
			
			state.setString(1, p.getNome());
			state.setFloat(2, p.getPreco());
			state.setString(3, p.getPatchIcon());
			state.setString(4, p.getLocalProduzido());
			state.setString(5, p.getContatoDistribuidora());
			state.setString(6, p.getDecricao());
			state.setString(7, String.valueOf(p.getCategoria()));			
			
							
			state.execute();
			
			state.close();
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
			PreparedStatement command = conexaoSQL.getConexao().prepareStatement(queryCommand);
			command.setInt(1, id);
			command.execute();
			
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

			PreparedStatement estado = conexaoSQL.getConexao().prepareStatement(queryCommand);
			ResultSet statement = estado.executeQuery();
			
			String id,nome;
			float preco;
			
			while(statement.next()) {
				
				id=statement.getString("id");
				nome=statement.getString("nome");
				preco=Float.parseFloat(statement.getString("preco"));
				
				produtoList.add(new Produto(id,nome,preco));
			}
			
			
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
		
		Produto produto = new Produto();
		
		try {

			PreparedStatement estado = conexaoSQL.getConexao().prepareStatement(queryCommand);
			estado.setInt(1,id);
			ResultSet statement = estado.executeQuery();
			
			if(statement.next()) {
				statement.first(); //Seta na primeira coluna
				
				produto.setPreco(Float.parseFloat(statement.getString("preco")));
				produto.setNome(statement.getString("nome"));
				produto.setCodigo(statement.getString("id"));
				produto.setPatchIcon(statement.getString("caminhoFoto"));
				produto.setContatoDistribuidora(statement.getString("contatoDistribuidora"));
				produto.setLocalProduzido(statement.getString("localproduzido"));
				produto.setDecricao(statement.getString("descricao"));
				produto.setCategoria(Categorias.valueOf(statement.getString("categoria")));
			}
			else return null;
		}catch(SQLException io) {
			io.printStackTrace();
		}
		
		
		conexaoSQL.closeConexao();

		return produto;
	}
	
	public static void editarProduto(Produto p) {
		String queryString = 
				"update produto set "
				+"nome = ?"
				+",preco = ?"
				+",caminhoFoto = ?"
				+",localproduzido = ?"
				+",contatoDistribuidora = ?"
				+",descricao = ?"
				+",categoria = ?"
				+" where id = ?";
		
		ConexaoMySQL conexao = new ConexaoMySQL();
		
	}
	
	
}