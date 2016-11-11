package com.javalingo.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Jogo extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected static final String String = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo frame = new Jogo(String, String, String, String, String, String, String);
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
	public Jogo(String dificuldade, String questao, String resposta, String altA, String altB, String altC, String altD) {
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
		
		
		JLabel lblNvel = new JLabel("Nível: " + dificuldade);
		lblNvel.setBounds(191, 11, 85, 14);
		contentPane.add(lblNvel);
		
		
		JLabel label = new JLabel("Questao: " + questao);
		label.setBounds(10, 63, 414, 42);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton(altA);
		btnNewButton.setBounds(10, 193, 188, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAlternativaB = new JButton(altB);
		btnAlternativaB.setBounds(215, 193, 209, 23);
		contentPane.add(btnAlternativaB);
		
		JButton button_1 = new JButton(altC);
		button_1.setBounds(10, 227, 195, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton(altD);
		button_2.setBounds(215, 227, 209, 23);
		contentPane.add(button_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Jogo.class.getResource("/com/javalingo/img/Imagens/fundo3.jpg")));
		label_1.setBounds(0, 0, 434, 261);
		contentPane.add(label_1);
		
		
		
		
		
	}
}
