package com.javalingo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

import com.javalingo.model.Usuario;
import com.javalingo.repository.UsuarioDAO;

import com.javalingo.view.Login;
import com.javalingo.view.Principal;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ctUsuario;
	private JPasswordField ctSenha;
	private JButton btnLogar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Javalingo - Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int WIDTH = 450;
		int HEIGHT = 300;
		int x = (screen.width - WIDTH) / 2;
		int y = (screen.height - HEIGHT) / 2;
		setBounds(x, y, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuário :");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(125, 160, 56, 18);
		contentPane.add(lblUsuario);

		ctUsuario = new JTextField();
		ctUsuario.setBounds(191, 160, 120, 20);
		contentPane.add(ctUsuario);
		ctUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha   :");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(125, 190, 56, 18);
		contentPane.add(lblSenha);

		ctSenha = new JPasswordField();
		ctSenha.setBounds(191, 190, 120, 20);
		contentPane.add(ctSenha);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
				dispose();

			}
		});
		btnVoltar.setIcon(new ImageIcon(Tutorial.class.getResource("/com/javalingo/img/Icones/voltar2.png")));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setFocusable(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(30, 144, 255));
		btnVoltar.setBounds(10, 232, 58, 18);
		contentPane.add(btnVoltar);
		btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = new Usuario();
				usuario = usuarioDAO.Acesso(ctUsuario.getText(), ctSenha.getText());

				if (UsuarioDAO.acesso) {
					JOptionPane.showMessageDialog(null, "Bem Vindo(a), " + usuario.getNome(), "Logado!",
							JOptionPane.INFORMATION_MESSAGE);
					long id = usuario.getIdUsuario();
					String s = Long.toString(id);
					Principal p = new Principal(usuario.getNome(), s);
					p.setVisible(true);
					dispose();

				} else if (ctUsuario.getText().equals("idsoft") && ctSenha.getText().equals("javalingo")) {
					JOptionPane.showMessageDialog(null, "Admin Logado!");
					PrincipalAdmin pa = new PrincipalAdmin();
					pa.setVisible(true);
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Login ou Senha Incorretos");
				}
			}
		});
		btnLogar.setIcon(new ImageIcon(Login.class.getResource("/com/javalingo/img/Icones/login2.png")));
		btnLogar.setForeground(Color.WHITE);
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogar.setFocusable(false);
		btnLogar.setContentAreaFilled(false);
		btnLogar.setBorder(null);
		btnLogar.setBackground(new Color(30, 144, 255));
		btnLogar.setBounds(364, 232, 58, 18);
		contentPane.add(btnLogar);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Login.class.getResource("/com/javalingo/img/Imagens/fundo2.jpg")));
		lblFundo.setBounds(0, 0, 434, 261);
		contentPane.add(lblFundo);
	}

	public void play(String nomedoaudio) {

		URL url = getClass().getResource(nomedoaudio + ".wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();

	}

	public JTextField getCtUsuario() {
		return ctUsuario;
	}

	public void setCtUsuario(JTextField ctUsuario) {
		this.ctUsuario = ctUsuario;
	}

	public JPasswordField getCtSenha() {
		return ctSenha;
	}

	public void setCtSenha(JPasswordField ctSenha) {
		this.ctSenha = ctSenha;
	}
}
