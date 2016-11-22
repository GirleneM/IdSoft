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
		UIManager.getDefaults().put("OptionPane.background", new Color(100, 149, 237));
		UIManager.put("Panel.background", new Color(100, 149, 237));
		UIManager.put("Button.background", new Color(100, 149, 237));
		UIManager.put("Button.foreground", new Color(255, 255, 255));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("TAHOMA", Font.PLAIN, 14)));
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("TAHOMA", Font.PLAIN, 14)));
		UIManager.put("OptionPane.messageForeground", Color.WHITE);

		JButton btnSobre = new JButton("Sobre");
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
		btnSobre.setFocusable(false);
		btnSobre.setContentAreaFilled(false);
		btnSobre.setBorder(null);
		btnSobre.setBackground(new Color(30, 144, 255));
		btnSobre.setBounds(366, 10, 58, 18);
		contentPane.add(btnSobre);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login l = new Login();
				l.setVisible(true);
				dispose();

			}
		});
		btnLogin.setIcon(new ImageIcon(Tutorial.class.getResource("/com/javalingo/img/Icones/login2.png")));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setFocusable(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setBounds(150, 160, 56, 18);
		contentPane.add(btnLogin);

		JButton btnRank = new JButton("Rank");
		btnRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Rank r = new Rank();
				r.setVisible(true);
				dispose();

			}
		});
		btnRank.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/javalingo/img/Icones/rank.png")));
		btnRank.setForeground(Color.WHITE);
		btnRank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRank.setFocusable(false);
		btnRank.setContentAreaFilled(false);
		btnRank.setBorder(null);
		btnRank.setBackground(new Color(30, 144, 255));
		btnRank.setBounds(228, 160, 54, 18);
		contentPane.add(btnRank);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroUsuario c1 = new CadastroUsuario();
				c1.setVisible(true);
				dispose();

			}
		});
		btnCadastrar.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/javalingo/img/Icones/new.png")));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setFocusable(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBorder(null);
		btnCadastrar.setBackground(new Color(30, 144, 255));
		btnCadastrar.setBounds(176, 195, 82, 18);
		contentPane.add(btnCadastrar);

		JButton btnSair = new JButton("Sair");
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
		btnSair.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/javalingo/img/Icones/logout2.png")));
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setFocusable(false);
		btnSair.setContentAreaFilled(false);
		btnSair.setBorder(null);
		btnSair.setBackground(new Color(30, 144, 255));
		btnSair.setBounds(195, 230, 44, 18);
		contentPane.add(btnSair);

		JLabel lblFundo = new JLabel("");
		lblFundo.setForeground(Color.WHITE);
		lblFundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/javalingo/img/Imagens/fundo2.jpg")));
		lblFundo.setBounds(0, 0, 434, 261);
		contentPane.add(lblFundo);
	}
}
