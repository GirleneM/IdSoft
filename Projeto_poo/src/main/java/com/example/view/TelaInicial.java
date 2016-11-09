package com.example.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setTitle("Javalingo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JButton btLogin = new JButton("Login");
		btLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLogin.setForeground(Color.WHITE);
		btLogin.setBackground(new Color(100, 149, 237));
		btLogin.setIcon(new ImageIcon(
				"C:\\Users\\mateus\\Documents\\workspace-sts-3.8.2.RELEASE\\POO_TRAB_JAVALINGO2.0\\src\\main\\java\\com\\javalingo\\img\\Icones\\login2.png"));
		btLogin.setBorderPainted(false);
		btLogin.setContentAreaFilled(false);
		btLogin.setFocusPainted(false);
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btLogin.setBounds(161, 159, 120, 23);
		contentPane.add(btLogin);

		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btCadastrar.setBackground(new Color(100, 149, 237));
		btCadastrar.setForeground(Color.WHITE);
		btCadastrar.setIcon(new ImageIcon(
				"C:\\Users\\mateus\\Documents\\workspace-sts-3.8.2.RELEASE\\POO_TRAB_JAVALINGO2.0\\src\\main\\java\\com\\javalingo\\img\\Icones\\user2.png"));
		btCadastrar.setBorderPainted(false);
		btCadastrar.setContentAreaFilled(false);
		btCadastrar.setFocusPainted(false);
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroUsuario c1 = new CadastroUsuario();
				c1.setVisible(true);
				dispose();
			}
		});
		btCadastrar.setBounds(161, 193, 120, 23);
		contentPane.add(btCadastrar);

		JButton btSair = new JButton("Sair");
		btSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSair.setBackground(new Color(100, 149, 237));
		btSair.setForeground(Color.WHITE);
		btSair.setIcon(new ImageIcon(
				"C:\\Users\\mateus\\Documents\\workspace-sts-3.8.2.RELEASE\\POO_TRAB_JAVALINGO2.0\\src\\main\\java\\com\\javalingo\\img\\Icones\\logout2.png"));
		btSair.setBorderPainted(false);
		btSair.setContentAreaFilled(false);
		btSair.setFocusPainted(false);
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Deseja Realmente Sair?", "Selecione uma opção",
						JOptionPane.OK_CANCEL_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else if (i == JOptionPane.CANCEL_OPTION) {
				}
			}
		});
		btSair.setBounds(161, 227, 120, 23);
		contentPane.add(btSair);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\mateus\\Documents\\workspace-sts-3.8.2.RELEASE\\POO_TRAB_JAVALINGO2.0\\src\\main\\java\\com\\javalingo\\img\\Icones\\fundo2.jpg"));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
	}

}
