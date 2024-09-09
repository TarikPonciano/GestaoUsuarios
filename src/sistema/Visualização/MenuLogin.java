
package sistema.Visualização;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.Controle.UsuarioDAO;
import sistema.Modelo.Usuario;
import sistema.Modelo.UsuarioLogado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuLogin extends JFrame {
	static UsuarioDAO tabelaUsuario = new UsuarioDAO();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuLogin telalogin = new MenuLogin();
					telalogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_gestor_incio = new JLabel("Bem vindo a Gestão Financeira");
		lbl_gestor_incio.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lbl_gestor_incio.setBounds(88, 11, 269, 14);
		contentPane.add(lbl_gestor_incio);
		
		JLabel lbl_inicio_login = new JLabel("Usuario/Apelido:");
		lbl_inicio_login.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lbl_inicio_login.setBounds(25, 96, 132, 14);
		contentPane.add(lbl_inicio_login);
		
		textField = new JTextField();
		textField.setBounds(25, 124, 132, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lbl_senha_inicio = new JLabel("Senha:");
		lbl_senha_inicio.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lbl_senha_inicio.setBounds(25, 165, 63, 14);
		contentPane.add(lbl_senha_inicio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(25, 190, 132, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btn_login_inicio = new JButton("Login");
		btn_login_inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = tabelaUsuario.buscarUsuarioPorEmail(textField.getText());
				
				if (usuario != null) {
					if (usuario.getSenha().equals(textField_1.getText())) {
						UsuarioLogado instancia = UsuarioLogado.retornarUsuario();
						instancia.setInformacoesUsuario(usuario);
						
						MenuPrincipal tela = new MenuPrincipal();
						tela.setVisible(true);
						dispose();
					}
				}
				
				
//				String emailDigitado = textField.getText();
//				String senhaDigitada = textField_1.getText();
//				
//				if (emailDigitado.equals("")) {
//					JOptionPane.showMessageDialog(btn_login_inicio, "Digite um email válido");
//				}
//				else if (senhaDigitada.equals("")) {
//					JOptionPane.showMessageDialog(btn_login_inicio, "Digite uma senha válida");
//				}
//				else
//				{
//				Usuario usuario = tabelaUsuario.buscarUsuarioPorEmail(emailDigitado);
//				
//
//				if (usuario == null) {
//					JOptionPane.showMessageDialog(btn_login_inicio, "Não foi encontrado usuário com o email digitado!");
//				}else {
//					if (senhaDigitada.equals(usuario.getSenha())) {
//					
//						JOptionPane.showMessageDialog(btn_login_inicio, "Acesso Garantido!");
//						
//					MenuPrincipal telaPrincipal = new MenuPrincipal();
//					telaPrincipal.setVisible(true);
//							
//					dispose();
//					}
//					else {
//						JOptionPane.showMessageDialog(btn_login_inicio, "Senha errada!");
//					}
//					
//				}
//				
//
//				}
			}
		});
		btn_login_inicio.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		btn_login_inicio.setBounds(265, 114, 112, 35);
		contentPane.add(btn_login_inicio);
		
		
	}

}
