package dados;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//import com.mysql.jdbc.Connection; se necessário, alterar:
import java.sql.Connection;

public class ConexaoMySQL {
	private String database = "bc_felipe_vieira";
	
	private String usuario = "root";
	private String senha = "root";
	
	//url=endereço do servidor MySQL
	private String url_mysql = "jdbc:mysql://localhost:3306/"+database;
	private String url_mariadb = "jdbc:mariadb://localhost:3306/"+database;
	
	private Connection conexao;
	
	/*
	 * Método que retornar uma conexão ao banco de dados "test"
	 * 
	 * */
	public ConexaoMySQL() {
		
		if(!this.conectarMariaDB() && !this.conectarMySQL()) {
			JOptionPane.showMessageDialog(null, "Sem sucesso ao conectar o banco dados", database, JOptionPane.CANCEL_OPTION);
			System.exit(-1);
		}
	}
	
	public boolean conectarMariaDB() {
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			conexao = DriverManager.getConnection(url_mariadb,usuario,senha);
			return true;
		}catch (ClassNotFoundException e) {
			return false;
		}catch (SQLException e) {
			return false;
		}

		
	}
	
	public boolean conectarMySQL() {
		
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(url_mysql,usuario,senha);
			return true;
		}catch (ClassNotFoundException e) {
			return false;
		}
		catch (SQLException e) {
			return false;
		}
		
	}

	public void closeConexao() {
		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() {
		return this.conexao;
	}
	
}