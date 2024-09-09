package sistema.Controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistema.Modelo.Usuario;

public class UsuarioDAO extends Conexao{

	public UsuarioDAO() {
		super("root", "Aluno", "sistemarh");
	}
	// Criar a função buscarUsuarios
	// Função que conecta, consulta todos os usuários da tabela usuários, imprime todos na tela e desconecta
	
	public List<Usuario> buscarTodosUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		conectar();
		
		try {
			// SELECT * FROM usuarios
			st = con.createStatement();
			
			rs = st.executeQuery("SELECT * FROM usuarios");
			
			while(rs.next()) {
				Usuario usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				
				usuarios.add(usuario);
			}
			
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		desconectar();
		return usuarios;
	}
	
	public Usuario buscarUsuarioPorEmail(String email) {
		Usuario usuario = null;
		conectar();
		
		try {
			pst = con.prepareStatement("SELECT * FROM usuarios WHERE email_usuario = ?");
			pst.setString(1, email);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		desconectar();
		return usuario;
		
		
		
	}
	

}
