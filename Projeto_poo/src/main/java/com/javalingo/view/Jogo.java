package com.javalingo.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		setTitle("Javalingo - " + dificuldade);
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
		
		
		JLabel lblQuestao = new JLabel("<html><p align = justify>Questao: " + questao + "</p></html>");
		lblQuestao.setForeground(new Color(139, 69, 19));
		lblQuestao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuestao.setBounds(35, 11, 172, 203);
		contentPane.add(lblQuestao);
		
		JButton btnAltA = new JButton(altA);
		btnAltA.setBackground(new Color(139, 69, 19));
		btnAltA.setBorderPainted(false);
		btnAltA.setFocusPainted(false);
		btnAltA.setForeground(Color.WHITE);
		btnAltA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltA.setBounds(233, 23, 156, 46);
		contentPane.add(btnAltA);
		btnAltA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnAltB = new JButton(altB);
		btnAltB.setBackground(new Color(139, 69, 19));
		btnAltB.setBorderPainted(false);
		btnAltB.setFocusPainted(false);
		btnAltB.setForeground(Color.WHITE);
		btnAltB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltB.setBounds(233, 80, 156, 46);
		contentPane.add(btnAltB);
		btnAltB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnAltC = new JButton(altC);
		btnAltC.setBackground(new Color(139, 69, 19));
		btnAltC.setBorderPainted(false);
		btnAltC.setFocusPainted(false);
		btnAltC.setForeground(Color.WHITE);
		btnAltC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltC.setBounds(233, 137, 156, 46);
		contentPane.add(btnAltC);
		btnAltC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnAltD = new JButton(altD);
		btnAltD.setBackground(new Color(139, 69, 19));
		btnAltD.setBorderPainted(false);
		btnAltD.setFocusPainted(false);
		btnAltD.setForeground(Color.WHITE);
		btnAltD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltD.setBounds(233, 194, 156, 46);
		contentPane.add(btnAltD);
		btnAltD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Jogo.class.getResource("/com/javalingo/img/Imagens/livro.png")));
		lblFundo.setBounds(0, 0, 434, 261);
		contentPane.add(lblFundo);
		
	}
}
