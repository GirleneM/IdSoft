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
		lblUsuario.setBounds(100, 153, 57, 17);
		contentPane.add(lblUsuario);

		ctUsuario = new JTextField();
		ctUsuario.setBounds(167, 153, 120, 20);
		contentPane.add(ctUsuario);
		ctUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha   :");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(100, 182, 57, 20);
		contentPane.add(lblSenha);

		JButton btnLogar = new JButton("Logar");
		btnLogar.setForeground(Color.WHITE);
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogar.setBackground(new Color(100, 149, 237));
		btnLogar.setIcon(new ImageIcon(
				"C:\\img\\Icones\\login2.png"));
		btnLogar.setBorder(null);
		btnLogar.setFocusable(false);
		btnLogar.setContentAreaFilled(false);
		btnLogar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = new Usuario();
				usuario = usuarioDAO.Acesso(ctUsuario.getText(), ctSenha.getText());

				if (UsuarioDAO.acesso) {
					JOptionPane.showMessageDialog(null, "Bem Vindo(a), " + usuario.getNome(), "Logado!", JOptionPane.INFORMATION_MESSAGE);
					// Chama uma tela
					Principal p = new Principal();
					p.setVisible(true);
					dispose();

				} else if (ctUsuario.getText().equals("idsoft") && ctSenha.getText().equals("javalingo")) {
					JOptionPane.showMessageDialog(null, "Admin Logado!");
					// Chama uma tela
					PrincipalAdmin pa = new PrincipalAdmin();
					pa.setVisible(true);
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Login ou Senha Incorretos");
				}
			}
		});
		btnLogar.setBounds(335, 227, 89, 23);
		contentPane.add(btnLogar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(100, 149, 237));
		btnVoltar.setIcon(new ImageIcon(
				"C:\\img\\Icones\\voltar2.png"));
		btnVoltar.setBorder(null);
		btnVoltar.setFocusable(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);

		ctSenha = new JPasswordField();
		ctSenha.setBounds(167, 184, 120, 20);
		contentPane.add(ctSenha);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\img\\Icones\\fundo2.jpg"));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
	}

	public void play(String nomedoaudio) {
		URL url = getClass().getResource(nomedoaudio + ".wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}

}
