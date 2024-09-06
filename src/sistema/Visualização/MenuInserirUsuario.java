package sistema.Visualização;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;

public class MenuInserirUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton botaoVoltar;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInserirUsuario frame = new MenuInserirUsuario();
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
	public MenuInserirUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Inserir Usuário");
		setResizable(false);;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		botaoVoltar = new JButton("");
		botaoVoltar.setIcon(new ImageIcon(MenuVerUsuarios.class.getResource("/Resources/Images/back-flat-color-outline-icon-free-png.png")));
	
		botaoVoltar.setBounds(10, 11, 80, 40);
		botaoVoltar.addActionListener(e ->{
			JFrame janela = new MenuPrincipal();
			janela.setVisible(true);
			
			dispose();
		});
		contentPane.setLayout(null);
		contentPane.add(botaoVoltar);

		setContentPane(contentPane);
		
		JLabel rotuloTitulo = new JLabel("Cadastro de Usuários");
		
		rotuloTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		rotuloTitulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
		rotuloTitulo.setBounds(91, 11, 602, 93);
		contentPane.add(rotuloTitulo);
		
		panel = new JPanel();
		panel.setBounds(217, 140, 350, 390);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);
		GridBagConstraints gbc = new GridBagConstraints();
		
	
	}
}
