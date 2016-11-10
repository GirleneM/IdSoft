package com.javalingo.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;

public class PrincipalAdmin extends JFrame {

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
					PrincipalAdmin frame = new PrincipalAdmin();
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
	public PrincipalAdmin() {
		setTitle("Javalingo - Painel do Administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int WIDTH = 450;
		int HEIGHT = 300;
		int x = (screen.width - WIDTH) / 2;
		int y = (screen.height - HEIGHT) / 2;
		setBounds(x, y, WIDTH, HEIGHT);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		setJMenuBar(menuBar);

		JMenu mnNovo = new JMenu("Novo");
		mnNovo.setIcon(new ImageIcon(PrincipalAdmin.class.getResource("/com/javalingo/img/Icones/add.png")));
		mnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnNovo);

		JMenuItem mntmQuesto = new JMenuItem("Questões");
		mntmQuesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarQuestao aq = new AdicionarQuestao();
				aq.setVisible(true);
				dispose();
			}
		});
		mntmQuesto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmQuesto.setIcon(new ImageIcon(PrincipalAdmin.class.getResource("/com/javalingo/img/Icones/questao.png")));
		mnNovo.add(mntmQuesto);

		JMenu mnLista = new JMenu("Lista");
		mnLista.setIcon(new ImageIcon(PrincipalAdmin.class.getResource("/com/javalingo/img/Icones/listar.png")));
		mnLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnLista);

		JMenuItem mntmUsuarios = new JMenuItem("Usuários");
		mntmUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaUsuario lu = new ListaUsuario();
				lu.setVisible(true);
				dispose();
			}
		});
		mntmUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmUsuarios.setIcon(new ImageIcon(PrincipalAdmin.class.getResource("/com/javalingo/img/Icones/user.png")));
		mnLista.add(mntmUsuarios);
		
		JMenuItem mntmQuestoes = new JMenuItem("Questoes");
		mntmQuestoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaQuestao lq= new ListaQuestao();
				lq.setVisible(true);
				dispose();
			}
		});
		mntmQuestoes.setIcon(new ImageIcon(PrincipalAdmin.class.getResource("/com/javalingo/img/Icones/questao.png")));
		mntmQuestoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnLista.add(mntmQuestoes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBorderPainted(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setFocusPainted(false);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = JOptionPane.showConfirmDialog(null, "Deseja Sair?", "Selecione uma Opção",
						JOptionPane.OK_CANCEL_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Deslogado com Sucesso!", "Deslogado!",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
					Login l =new Login();
					l.setVisible(true);
				} else if (i == JOptionPane.NO_OPTION) {
				}
			}
		});
		btnLogout.setBackground(new Color(100, 149, 237));
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogout.setIcon(new ImageIcon(PrincipalAdmin.class.getResource("/com/javalingo/img/Icones/logout2.png")));
		btnLogout.setBounds(335, 11, 99, 23);
		contentPane.add(btnLogout);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PrincipalAdmin.class.getResource("/com/javalingo/img/Imagens/fundo2.jpg")));
		label.setBounds(0, 0, 434, 240);
		contentPane.add(label);
	}

	public void play(String nomedoaudio) {
		URL url = getClass().getResource(nomedoaudio + ".wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}
}
