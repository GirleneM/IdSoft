package com.javalingo.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Tutorial extends JFrame {

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
					Tutorial frame = new Tutorial();
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
	public Tutorial() {
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
		
		JButton btnVoltar = new JButton("Jogar");
		btnVoltar.setBorder(null);
		btnVoltar.setFocusable(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(30, 144, 255));
		btnVoltar.setIcon(new ImageIcon(Tutorial.class.getResource("/com/javalingo/img/Icones/play2.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(335, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblTexto = new JLabel("<html><u><center>Tutorial</center></u><br><p align = justify>O Javalingo é um jogo destinado "
				+ "a testar os conhecimentos e o grau de afinidade em JAVA. O usuário terá de responder as perguntas e "
				+ "escolher a alternativa que julgue correta dentre as quatro que estarão disponíveis.</p></html>");
		lblTexto.setForeground(Color.WHITE);
		lblTexto.setVerticalAlignment(SwingConstants.TOP);
		lblTexto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTexto.setBounds(38, 11, 172, 220);
		contentPane.add(lblTexto);
		
		JLabel lblTexto2 = new JLabel("<html><p align = justify>Ao fim do questionário será exibido a quantidade de erros e acertos "
				+ "e um percentual do quanto ele está apto a progrmar em JAVA.</p></html>");
		lblTexto2.setForeground(Color.WHITE);
		lblTexto2.setVerticalAlignment(SwingConstants.TOP);
		lblTexto2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTexto2.setBounds(229, 28, 172, 203);
		contentPane.add(lblTexto2);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Tutorial.class.getResource("/com/javalingo/img/Imagens/fundo2.jpg")));
		lblFundo.setBounds(0, 0, 434, 261);
		contentPane.add(lblFundo);
	}
}
