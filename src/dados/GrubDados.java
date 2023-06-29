package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import produto.Produto;

public class GrubDados {

	
	public static void salvar(Produto p) {
		
		String url_command = "insert into produto(nome,preco) values(?,?)";
		
		Connection conexao = new ConexaoMySQL().conectar();
		
		try {
			PreparedStatement state = conexao.prepareStatement(url_command);
			state.setString(1, p.getNome());
			state.setFloat(2, p.getPreco());
			state.execute();
			state.close();
		}catch(SQLException io)
		{
			io.printStackTrace();
		}
		try {
			conexao.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	

	public static void remove(String produtoNome) {
		String sqlCommand = "delete from produto where nome = ?";
		

		Connection conexao = new ConexaoMySQL().conectar();

			
		try {
			PreparedStatement command = conexao.prepareStatement(sqlCommand);
			command.setString(1, produtoNome);
			command.execute();
			
		}catch(SQLException io) {
			io.printStackTrace();
		}
		
		
		try {
			conexao.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static ArrayList<Produto> buscaLista() {
				
		String urlCommand = "select * from produto";
		

		Connection conexao = new ConexaoMySQL().conectar();

		ArrayList<Produto> produtoList = new ArrayList<Produto>();
		
		try {

			PreparedStatement estado = conexao.prepareStatement(urlCommand);
			ResultSet statement = estado.executeQuery();
			
			
			while(statement.next()) {
				produtoList.add(new Produto(statement.getString("id"),statement.getString("nome"),Float.parseFloat(statement.getString("preco"))));
			}
			
			
		}catch(SQLException io) {
			io.printStackTrace();
		}
		
		
		try {
			conexao.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return produtoList;
	}
	
	public static Produto busca(String nome) {
		
		String urlCommand = "select * from produto where nome = ?";
		

		Connection conexao = new ConexaoMySQL().conectar();
		
		
		Produto produto = new Produto();
		
		try {

			PreparedStatement estado = conexao.prepareStatement(urlCommand);
			estado.setString(1,nome);
			ResultSet statement = estado.executeQuery();
			
			
			while(statement.next()) {
				produto.setPreco(Float.parseFloat(statement.getString("preco")));
				produto.setNome(statement.getString("nome"));
				produto.setCodigo(statement.getString("id"));
			}
			System.out.println(produto.getNome());
			
		}catch(SQLException io) {
			io.printStackTrace();
		}
		
		
		try {
			conexao.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return produto;
	}
}