package dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import produto.Produto;

public class GrubDados {
	
	public GrubDados() {
		
	}
	/*
	 * Adicionar um novo produto ao banco de dados utilizando os valores de um objeto produto já existente
	 * */
	public static void salvar(Produto p) {
		
		String url_command = "insert into produto(nome,preco,caminhoFoto,localproduzido,contatoDistribuidora,descricao) values(?,?,?,?,?,?)";

		ConexaoMySQL conexaoSQL = new ConexaoMySQL();
		
		try {
			PreparedStatement state = conexaoSQL.getConexao().prepareStatement(url_command);
			
			state.setString(1, p.getNome());
			state.setFloat(2, p.getPreco());
			state.setString(3, p.getPatchIcon());
			state.setString(4, p.getLocalProduzido());
			state.setString(5, p.getContatoDistribuidora());
			state.setString(6, p.getDecricao());			
			
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
		String sqlCommand = "delete from produto where id = ?";
		
		ConexaoMySQL conexaoSQL = new ConexaoMySQL();
			
		try {
			PreparedStatement command = conexaoSQL.getConexao().prepareStatement(sqlCommand);
			command.setInt(1, id);
			command.execute();
			
		}catch(SQLException io) {
			io.printStackTrace();
		}
		
		
		conexaoSQL.closeConexao();
	}
	
	/*
	 * Método retornar uma Lista dos produtos no banco de dados
	 * */
	public static ArrayList<Produto> buscaLista() {
				
		String urlCommand = "select * from produto";
		
		//Connection conexao = new ConexaoMySQL().conectar();

		ConexaoMySQL conexaoSQL = new ConexaoMySQL();
		
		
		ArrayList<Produto> produtoList = new ArrayList<Produto>();
		
		try {

			PreparedStatement estado = conexaoSQL.getConexao().prepareStatement(urlCommand);
			ResultSet statement = estado.executeQuery();
			
			
			while(statement.next()) {
				produtoList.add(new Produto(statement.getString("id"),statement.getString("nome"),Float.parseFloat(statement.getString("preco")),statement.getString("descricao")));
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
		
		String urlCommand = "select * from produto where id = ?";
		

		//Connection conexao = new ConexaoMySQL_descontinuado().conectar();
		ConexaoMySQL conexaoSQL = new ConexaoMySQL();
		
		Produto produto = new Produto();
		
		try {

			PreparedStatement estado = conexaoSQL.getConexao().prepareStatement(urlCommand);
			estado.setInt(1,id);
			ResultSet statement = estado.executeQuery();
			
			
			while(statement.next()) {
				produto.setPreco(Float.parseFloat(statement.getString("preco")));
				produto.setNome(statement.getString("nome"));
				produto.setCodigo(statement.getString("id"));
				produto.setPatchIcon(statement.getString("caminhoFoto"));
				produto.setContatoDistribuidora(statement.getString("contatoDistribuidora"));
				produto.setLocalProduzido(statement.getString("localproduzido"));
				produto.setDecricao(statement.getString("descricao"));
			}
			
		}catch(SQLException io) {
			io.printStackTrace();
		}
		
		
		conexaoSQL.closeConexao();

		return produto;
	}
}