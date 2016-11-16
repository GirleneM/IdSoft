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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FimJogo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane_1;
	protected static final String String = null;
	double resultado = 0;
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
	public FimJogo(String idUser, String nomeUser, String certas, String erradas) {
		setTitle("Javalingo - Resultado");
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
		
		JButton btnTela = new JButton("Tela Inicial de " + nomeUser);
		btnTela.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTela.setForeground(Color.WHITE);
		btnTela.setBackground(new Color(100, 149, 237));
		btnTela.setBorder(null);
		btnTela.setFocusable(false);
		btnTela.setContentAreaFilled(false);
		btnTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal p = new Principal(nomeUser, idUser);
				p.setVisible(true);
				dispose();
			}
		});
		btnTela.setBounds(94, 227, 256, 23);
		contentPane_1.add(btnTela);
		
		JLabel lblUser = new JLabel(nomeUser);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUser.setBounds(178, 45, 83, 14);
		contentPane_1.add(lblUser);
		
		JLabel lblCertas = new JLabel("Acertos: " + certas);
		lblCertas.setForeground(Color.WHITE);
		lblCertas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCertas.setBounds(178, 70, 83, 14);
		contentPane_1.add(lblCertas);
		
		JLabel lblErradas = new JLabel("Erros: " + erradas);
		lblErradas.setForeground(Color.WHITE);
		lblErradas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErradas.setBounds(178, 95, 83, 14);
		contentPane_1.add(lblErradas);
		
		long id = Long.parseLong(certas);
		long id2 = Long.parseLong(erradas);
		resultado = (100 / (id + id2)) * id;
		String total = Double.toString(resultado);
		
		JLabel lblPercentual = new JLabel(total + "%");
		lblPercentual.setForeground(Color.WHITE);
		lblPercentual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPercentual.setBounds(178, 120, 83, 14);
		contentPane_1.add(lblPercentual);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(FimJogo.class.getResource("/com/javalingo/img/Imagens/fundo3.jpg")));
		lblFundo.setBounds(0, 0, 434, 261);
		contentPane_1.add(lblFundo);
	}
}
