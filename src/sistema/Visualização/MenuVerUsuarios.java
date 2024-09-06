package sistema.Visualização;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import sistema.Controle.UsuarioDAO;
import sistema.Modelo.Usuario;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MenuVerUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabelaUsuarios;
	private JButton botaoVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuVerUsuarios frame = new MenuVerUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuVerUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Ver Usuários");
		setResizable(false);;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneTabelaUsuarios = new JScrollPane();
		scrollPaneTabelaUsuarios.setBounds(87, 56, 610, 449);
		contentPane.add(scrollPaneTabelaUsuarios);
		
		DefaultTableModel modeloTabelaUsuarios = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "Email"
				}
			);
		UsuarioDAO bancoUsuario = new UsuarioDAO();
		
		List<Usuario> usuarios = bancoUsuario.buscarTodosUsuarios();
		
		for (Usuario u: usuarios) {
			Object[] informacoes = {u.getId(), u.getNome(), u.getEmail()};
			
			modeloTabelaUsuarios.addRow(informacoes);
			
		}
//		String[] informacoes = {"1", "tarik", "tarik@gmail"};
//		modeloTabelaUsuarios.addRow(informacoes);
		
		tabelaUsuarios = new JTable();
		tabelaUsuarios.setModel(modeloTabelaUsuarios);
		
		scrollPaneTabelaUsuarios.setViewportView(tabelaUsuarios);
		
		botaoVoltar = new JButton("");
		botaoVoltar.setIcon(new ImageIcon(MenuVerUsuarios.class.getResource("/Resources/Images/back-flat-color-outline-icon-free-png.png")));
	
		botaoVoltar.setBounds(10, 11, 80, 40);
		botaoVoltar.addActionListener(e ->{
			JFrame janela = new MenuPrincipal();
			janela.setVisible(true);
			
			dispose();
		});
		contentPane.add(botaoVoltar);
	}
}
