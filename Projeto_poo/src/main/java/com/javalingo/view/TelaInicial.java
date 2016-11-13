package com.javalingo.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
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
		UIManager.getDefaults().put("OptionPane.background",new Color(100, 149, 237));
		UIManager.put ("Panel.background", new Color(100, 149, 237));
		UIManager.put("Button.background", new Color(100, 149, 237));
		UIManager.put("Button.foreground", new Color(255, 255, 255));		
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("TAHOMA",Font.PLAIN,14)));
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("TAHOMA",Font.PLAIN,14)));
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(100, 149, 237));
		btnLogin.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/javalingo/img/Icones/login2.png")));
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(129, 159, 88, 23);
		contentPane.add(btnLogin);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBackground(new Color(100, 149, 237));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/javalingo/img/Icones/new.png")));
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroUsuario c1 = new CadastroUsuario();
				c1.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(160, 193, 114, 23);
		contentPane.add(btnCadastrar);

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setBackground(new Color(100, 149, 237));
		btnSair.setForeground(Color.WHITE);
		btnSair.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/javalingo/img/Icones/logout2.png")));
		btnSair.setBorderPainted(false);
		btnSair.setContentAreaFilled(false);
		btnSair.setFocusPainted(false);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Deseja realmente Sair?", "Selecione uma opção",
						JOptionPane.OK_CANCEL_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else if (i == JOptionPane.CANCEL_OPTION) {
				}
			}
		});
		
		JButton btnRank = new JButton("Rank");
		btnRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rank r1 = new Rank();
				r1.setVisible(true);
				dispose();
			}
		});
		btnRank.setBorderPainted(false);
		btnRank.setContentAreaFilled(false);
		btnRank.setFocusPainted(false);
		btnRank.setForeground(Color.WHITE);
		btnRank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRank.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/javalingo/img/Icones/rank.png")));
		btnRank.setBounds(217, 159, 88, 23);
		contentPane.add(btnRank);
		btnSair.setBounds(178, 227, 78, 23);
		contentPane.add(btnSair);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.setBorderPainted(false);
		btnSobre.setContentAreaFilled(false);
		btnSobre.setFocusPainted(false);
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre s = new Sobre();
				s.setVisible(true);
				dispose();
			}
		});
		btnSobre.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/javalingo/img/Icones/tutorial2.png")));
		btnSobre.setForeground(Color.WHITE);
		btnSobre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSobre.setBounds(320, 11, 104, 23);
		contentPane.add(btnSobre);

		JLabel lblFundo = new JLabel("");
		lblFundo.setForeground(Color.WHITE);
		lblFundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/javalingo/img/Imagens/fundo2.jpg")));
		lblFundo.setBounds(0, 0, 434, 261);
		contentPane.add(lblFundo);
	}
}
