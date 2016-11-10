package com.javalingo.view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class Principal extends JFrame {

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
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Javalingo - Tutorial");
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

		JLabel lblLogado = new JLabel("Bem Vindo, ");
		lblLogado.setForeground(Color.WHITE);
		lblLogado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogado.setBounds(10, 11, 87, 14);
		contentPane.add(lblLogado);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
					TelaInicial ti = new TelaInicial();
					ti.setVisible(true);
					dispose();
					
				} else if (i == JOptionPane.NO_OPTION) {
				}
			}
		});
		btnLogout.setIcon(new ImageIcon(
				"C:\\img\\Icones\\logout2.png"));
		btnLogout.setBounds(322, 7, 102, 23);
		contentPane.add(btnLogout);

		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.setIcon(new ImageIcon(
				"C:\\img\\Icones\\tutorial2.png"));
		btnTutorial.setForeground(Color.WHITE);
		btnTutorial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTutorial.setBorderPainted(false);
		btnTutorial.setContentAreaFilled(false);
		btnTutorial.setFocusPainted(false);
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTutorial.setBounds(174, 207, 102, 23);
		contentPane.add(btnTutorial);

		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnJogar.setIcon(new ImageIcon(
				"C:\\img\\Icones\\play2.png"));
		btnJogar.setForeground(Color.WHITE);
		btnJogar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnJogar.setBorderPainted(false);
		btnJogar.setContentAreaFilled(false);
		btnJogar.setFocusPainted(false);
		btnJogar.setBounds(174, 173, 102, 23);
		contentPane.add(btnJogar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\img\\Imagens\\fundo2.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	}

	public void play(String nomedoaudio) {
		URL url = getClass().getResource(nomedoaudio + ".wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}
}
