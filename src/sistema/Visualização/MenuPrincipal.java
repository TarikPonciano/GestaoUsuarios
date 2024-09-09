package sistema.Visualização;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import sistema.Modelo.Usuario;
import sistema.Modelo.UsuarioLogado;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usuarioLogado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		UsuarioLogado instancia = UsuarioLogado.retornarUsuario();
		Usuario usuario = instancia.getInformacoesUsuario();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Menu Principal");
		setResizable(false);;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel rotuloTitulo = new JLabel("Sistema de Gerenciamento de Usuários");
		rotuloTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		rotuloTitulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
		rotuloTitulo.setBounds(91, 11, 602, 93);
		contentPane.add(rotuloTitulo);
		
		JPanel painelMenuBotoes = new JPanel();
		painelMenuBotoes.setBackground(SystemColor.text);
		painelMenuBotoes.setBounds(324, 184, 135, 250);
		contentPane.add(painelMenuBotoes);
		painelMenuBotoes.setLayout(new GridLayout(3, 1, 0, 5));
		
		JButton botaoVerUsuarios = new JButton("Ver Usuários");
		botaoVerUsuarios.addActionListener(e -> {
			JFrame janela = new MenuVerUsuarios();
			janela.setVisible(true);
			dispose();
		});
		painelMenuBotoes.add(botaoVerUsuarios);
		
		JButton botaoInserirUsuario = new JButton("Inserir Usuario");
		botaoInserirUsuario.addActionListener(e -> {
			System.out.println("Inserir Usuario");
		});
		painelMenuBotoes.add(botaoInserirUsuario);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(e -> {
			dispose();
		});
		painelMenuBotoes.add(botaoSair);
		
		JLabel labelBemVindo = new JLabel("Bem vindo, "+usuario.getNome());
		labelBemVindo.setBounds(324, 115, 135, 14);
		contentPane.add(labelBemVindo);
	}
}
