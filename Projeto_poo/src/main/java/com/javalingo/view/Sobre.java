package com.javalingo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

public class Sobre extends JFrame {

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
					Sobre frame = new Sobre();
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
	public Sobre() {
		
		setTitle("Javalingo - Sobre");
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

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setIcon(new ImageIcon(Sobre.class.getResource("/com/javalingo/img/Icones/voltar2.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
				dispose();

			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblVerso = new JLabel("<html><p align = right>Versão 1.0<br>2016, Javalingo</p></html>");
		lblVerso.setForeground(Color.WHITE);
		lblVerso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVerso.setBounds(325, 203, 107, 47);
		contentPane.add(lblVerso);

		JLabel lblEmpresa = new JLabel("IDsotf");
		lblEmpresa.setForeground(Color.WHITE);
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmpresa.setBounds(195, 0, 239, 30);
		contentPane.add(lblEmpresa);

		JLabel lblEquipe = new JLabel("<html>Programador:<br><br>Raphael Oliveira<br>Mateus Daniel<br><br>"
				+ "Designer:<br><br>Luciano Gomes</html>");
		lblEquipe.setForeground(Color.WHITE);
		lblEquipe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEquipe.setBounds(10, 36, 122, 180);
		contentPane.add(lblEquipe);

		JLabel lblEquipe2 = new JLabel(
				"<html><p align = right>Testador:<br><br>Girlene Maria<br>Bruno Allison</p></html>");
		lblEquipe2.setForeground(Color.WHITE);
		lblEquipe2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEquipe2.setBounds(347, 36, 77, 117);
		contentPane.add(lblEquipe2);

		JLabel lblFundo = new JLabel("");
		lblFundo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFundo.setForeground(Color.WHITE);
		lblFundo.setIcon(new ImageIcon(Sobre.class.getResource("/com/javalingo/img/Imagens/fundo1.jpg")));
		lblFundo.setBounds(0, 0, 434, 261);
		contentPane.add(lblFundo);
	}
}
