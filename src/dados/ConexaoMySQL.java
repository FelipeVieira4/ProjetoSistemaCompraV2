package dados;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//import com.mysql.jdbc.Connection; se necessário, alterar:
import java.sql.Connection;

public class ConexaoMySQL {
	private String database = "test";
	private String usuario = "root";
	private String senha = "root";
	
	//url=endereço do servidor MySQL
	private String url = "jdbc:mysql://localhost:3306/"+database;
	
	private Connection conexao;
	
	/*
	 * Método que retornar uma conexão ao banco de dados "test"
	 * 
	 * */
	public ConexaoMySQL() {
		
		if(!this.conectar()) {
			JOptionPane.showMessageDialog(null, "Sem sucesso ao conectar o banco dados", database, JOptionPane.CANCEL_OPTION);
			System.exit(-1);
		}
	}
	
	public boolean conectar() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		try {
			conexao = DriverManager.getConnection(url,usuario,senha);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	

	public void closeConexao() {
		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("exports")
	public Connection getConexao() {
		return this.conexao;
	}
	
}