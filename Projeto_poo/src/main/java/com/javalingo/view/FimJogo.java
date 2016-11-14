package com.javalingo.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FimJogo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane_1;
	protected static final String String = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FimJogo frame = new FimJogo(String, String, String, String);
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
	public FimJogo(String dificuldade, String idQuestao, String idUser, String nomeUser) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int WIDTH = 450;
		int HEIGHT = 300;
		int x = (screen.width - WIDTH) / 2;
		int y = (screen.height - HEIGHT) / 2;
		setBounds(x, y, WIDTH, HEIGHT);
		new JPanel();
		contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		
		JButton btnTelaInicialDe = new JButton("Tela Inicial de " + nomeUser);
		btnTelaInicialDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal p = new Principal(nomeUser, idUser);
				p.setVisible(true);
				dispose();
			}
		});
		btnTelaInicialDe.setBounds(168, 11, 256, 23);
		contentPane_1.add(btnTelaInicialDe);
	}
}
