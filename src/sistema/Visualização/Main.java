package sistema.Visualização;

import java.util.List;

import sistema.Controle.UsuarioDAO;
import sistema.Modelo.Usuario;

public class Main {

	public static void main(String[] args) {
		UsuarioDAO tabelaUsuario = new UsuarioDAO();
		List<Usuario> usuarios = tabelaUsuario.buscarTodosUsuarios();
		
		System.out.println(usuarios);
		
		

	}

}
