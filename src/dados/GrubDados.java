package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import produto.Produto;

public class GrubDados {

	public static void salvarProduto(Produto p) {
		String sql = "insert into produto(nome,preco) values(?,?)";
	
		Connection id = new ConexaoMySQL().conectar();
	
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setString(1,p.getNome());
			command.setFloat(2, p.getPreco());
			command.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			id.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	
	public static void removeProduto(String produtoNome) {
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
	
}