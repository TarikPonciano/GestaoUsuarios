package sistema.Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	// Informações para conectar com o banco de dados
	private String url;
	private String user;
	private String password;
	private String database;
	
	// Objetos usados para consultar e manipular o banco
	protected Connection con = null; // Conexão que será estabelecida
	protected Statement st = null; // Objeto que permite executar comandos SQL
	protected PreparedStatement pst = null; // Objeto que permite executar comandos SQL que usem variáveis do java
	protected ResultSet rs = null; // Objeto que guarda os resultados das consultas (SELECT)
	
	public Conexao ( String user, String password, String database) {
		this.url = "jdbc:mysql://localhost:3306/";
		this.user = user;
		this.password = password;
		this.database = database;
	}
	
	public void conectar() {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection(url+database, user, password);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void desconectar() {
		
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		try {
			if (pst != null && !pst.isClosed()) {
				pst.close();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		try {
			if (st != null && !st.isClosed()) {
				st.close();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	
	}
	}
