package sistema;

import java.util.List;

import sistema.Controle.UsuarioDAO;
import sistema.Modelo.Usuario;
import sistema.Visualização.MenuPrincipal;

public class Main {

	public static void main(String[] args) {
		//Criação da janela Menu Principal
		try {
			MenuPrincipal frame = new MenuPrincipal();
			//Mostrar Janela
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
