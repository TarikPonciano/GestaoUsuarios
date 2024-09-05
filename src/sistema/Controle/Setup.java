package sistema.Controle;

import java.sql.SQLException;

public class Setup extends Conexao {
	

	public Setup() {
		super("root", "Aluno", "");
	}
	
	public void criarBanco() {
		conectar(); // Conectar com o banco
		
		// Realizar operação SQL
		try {
			// Criar o Statement
			st = con.createStatement();
			
			//Executo um SQL
			st.executeUpdate("DROP DATABASE IF EXISTS sistemarh");
			st.executeUpdate("CREATE DATABASE sistemarh");
			System.out.println("Banco criado com sucesso");
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		desconectar(); // Desconectar do banco
		// Retornar os resultados
	}
	
	public void criarTabelaUsuario() {
		conectar();
		
		try {
			st = con.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS sistemarh.usuarios");
			st.executeUpdate("CREATE TABLE sistemarh.usuarios ( id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "nome_usuario VARCHAR(255) NOT NULL,"
					+ "email_usuario VARCHAR(255) NOT NULL UNIQUE,"
					+ "senha_usuario VARCHAR(255) NOT NULL);");
			
			System.out.println("Tabela usuários criada com sucesso!");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		desconectar();
	}
	
	public void inserirUsuariosIniciais() {
		conectar();
		try {
			st = con.createStatement();
			
			String insertUsuarios = 
				    "INSERT INTO sistemarh.usuarios VALUES " +
				    "(1, 'João Silva', 'joao.silva@example.com', 'senha123'), " +
				    "(2, 'Maria Oliveira', 'maria.oliveira@example.com', 'senha456'), " +
				    "(3, 'Carlos Souza', 'carlos.souza@example.com', 'senha789'), " +
				    "(4, 'Ana Santos', 'ana.santos@example.com', 'senha101'), " +
				    "(5, 'Pedro Lima', 'pedro.lima@example.com', 'senha202'), " +
				    "(6, 'Julia Costa', 'julia.costa@example.com', 'senha303'), " +
				    "(7, 'Lucas Almeida', 'lucas.almeida@example.com', 'senha404'), " +
				    "(8, 'Mariana Ribeiro', 'mariana.ribeiro@example.com', 'senha505'), " +
				    "(9, 'Felipe Barros', 'felipe.barros@example.com', 'senha606'), " +
				    "(10, 'Beatriz Martins', 'beatriz.martins@example.com', 'senha707'), " +
				    "(11, 'Roberto Fernandes', 'roberto.fernandes@example.com', 'senha808'), " +
				    "(12, 'Carolina Rocha', 'carolina.rocha@example.com', 'senha909'), " +
				    "(13, 'Paulo Castro', 'paulo.castro@example.com', 'senha010'), " +
				    "(14, 'Fernanda Pinto', 'fernanda.pinto@example.com', 'senha111'), " +
				    "(15, 'Gabriel Mendes', 'gabriel.mendes@example.com', 'senha212'), " +
				    "(16, 'Isabela Cardoso', 'isabela.cardoso@example.com', 'senha313'), " +
				    "(17, 'Gustavo Rodrigues', 'gustavo.rodrigues@example.com', 'senha414'), " +
				    "(18, 'Renata Lima', 'renata.lima@example.com', 'senha515'), " +
				    "(19, 'Thiago Moreira', 'thiago.moreira@example.com', 'senha616'), " +
				    "(20, 'Patricia Farias', 'patricia.farias@example.com', 'senha717');";


			
			st.executeUpdate(insertUsuarios);
			System.out.println("Usuários inseridos com sucesso!");
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		desconectar();
		
	}

	public static void main(String[] args) {
		Setup inicializador = new Setup();
		inicializador.criarBanco();
		inicializador.criarTabelaUsuario();
		inicializador.inserirUsuariosIniciais();
		
		UsuarioDAO tabelaUsuarios = new UsuarioDAO();
		tabelaUsuarios.buscarTodosUsuarios();

	}

}
