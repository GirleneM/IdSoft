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
		setTitle("Javalingo - Sobre ");
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
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\mateus\\Documents\\workspace-sts-3.8.2.RELEASE\\POO_TRAB_JAVALINGO2.0\\src\\main\\java\\com\\javalingo\\img\\Icones\\voltar2.png"));
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
		
		JLabel lblJavalingo = new JLabel("2016, Javalingo");
		lblJavalingo.setForeground(Color.WHITE);
		lblJavalingo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJavalingo.setBounds(10, 11, 160, 23);
		contentPane.add(lblJavalingo);
		
		JLabel lblVerso = new JLabel("Versão 1.0");
		lblVerso.setForeground(Color.WHITE);
		lblVerso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVerso.setBounds(10, 38, 89, 23);
		contentPane.add(lblVerso);
		
		JLabel lblEquipeDeDesenvolvedores = new JLabel("Equipe de Desenvolvedores");
		lblEquipeDeDesenvolvedores.setForeground(Color.WHITE);
		lblEquipeDeDesenvolvedores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEquipeDeDesenvolvedores.setBounds(250, 11, 174, 23);
		contentPane.add(lblEquipeDeDesenvolvedores);
		
		JLabel lblRaphaelSanto = new JLabel("Raphael Santos");
		lblRaphaelSanto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRaphaelSanto.setForeground(Color.WHITE);
		lblRaphaelSanto.setBounds(300, 40, 124, 23);
		contentPane.add(lblRaphaelSanto);
		
		JLabel lblMateusDaniel = new JLabel("Mateus Daniel");
		lblMateusDaniel.setForeground(Color.WHITE);
		lblMateusDaniel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMateusDaniel.setBounds(300, 60, 124, 23);
		contentPane.add(lblMateusDaniel);
		
		JLabel lblBrunoAlisson = new JLabel("Bruno Alisson");
		lblBrunoAlisson.setForeground(Color.WHITE);
		lblBrunoAlisson.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBrunoAlisson.setBounds(300, 80, 124, 23);
		contentPane.add(lblBrunoAlisson);
		
		JLabel lblGirleneMaria = new JLabel("Girlene Maria");
		lblGirleneMaria.setForeground(Color.WHITE);
		lblGirleneMaria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGirleneMaria.setBounds(300, 100, 124, 23);
		contentPane.add(lblGirleneMaria);
		
		JLabel lblLucianoNeto = new JLabel("Luciano Neto");
		lblLucianoNeto.setForeground(Color.WHITE);
		lblLucianoNeto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLucianoNeto.setBounds(300, 120, 124, 23);
		contentPane.add(lblLucianoNeto);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setForeground(Color.WHITE);
		label.setIcon(new ImageIcon("C:\\Users\\mateus\\Documents\\workspace-sts-3.8.2.RELEASE\\POO_TRAB_JAVALINGO2.0\\src\\main\\java\\com\\javalingo\\img\\Icones\\fundo2.jpg"));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
	}
}
