package com.javalingo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Top3 extends JFrame {

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
					Top3 frame = new Top3();
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
	public Top3() {
		setTitle("Javalingo - Top 3");
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
		
		JLabel lblPrimeiro = new JLabel("Primeiro");
		lblPrimeiro.setFont(new Font("Exotc350 Bd BT", Font.PLAIN, 18));
		lblPrimeiro.setBounds(189, 63, 80, 14);
		contentPane.add(lblPrimeiro);
		
		JLabel lblSegundo = new JLabel("Segundo");
		lblSegundo.setFont(new Font("Exotc350 Bd BT", Font.PLAIN, 18));
		lblSegundo.setBounds(67, 95, 64, 23);
		contentPane.add(lblSegundo);
		
		JLabel lblTerceiro = new JLabel("Terceiro");
		lblTerceiro.setFont(new Font("Exotc350 Bd BT", Font.PLAIN, 18));
		lblTerceiro.setBounds(307, 119, 71, 14);
		contentPane.add(lblTerceiro);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tutorial.class.getResource("/com/javalingo/img/Icones/voltar.png")));
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setFocusable(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(30, 144, 255));
		btnVoltar.setBounds(0, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblRank = new JLabel("Javalingo");
		lblRank.setFont(new Font("Exotc350 Bd BT", Font.PLAIN, 18));
		lblRank.setBounds(188, 205, 80, 17);
		contentPane.add(lblRank);
		
		JButton btnRank = new JButton("Rank");
		btnRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rank r = new Rank();
				r.setVisible(true);
				dispose();
			}
		});
		btnRank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRank.setForeground(Color.BLACK);
		btnRank.setBackground(new Color(100, 149, 237));
		btnRank.setIcon(new ImageIcon(Top3.class.getResource("/com/javalingo/img/Icones/rank2.png")));
		btnRank.setBorderPainted(false);
		btnRank.setContentAreaFilled(false);
		btnRank.setFocusPainted(false);
		btnRank.setBounds(345, 227, 89, 23);
		contentPane.add(btnRank);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Top3.class.getResource("/com/javalingo/img/Imagens/rank.jpg")));
		lblFundo.setBounds(0, 0, 434, 261);
		contentPane.add(lblFundo);
	}
}
