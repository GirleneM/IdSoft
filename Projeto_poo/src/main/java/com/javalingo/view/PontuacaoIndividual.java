package com.javalingo.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PontuacaoIndividual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static final String String = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PontuacaoIndividual frame = new PontuacaoIndividual(String, String, String, String, String, String);
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
	public PontuacaoIndividual(String nomeUser, String certas, String erradas, String porcetagem, String testesfeitos, String idUser) {
		setTitle("Javalingo - Pontuação Individual");
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
		
		JLabel lblJogador = new JLabel("Jogador: "+ nomeUser);
		lblJogador.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJogador.setForeground(Color.WHITE);
		lblJogador.setBounds(0, 26, 434, 25);
		contentPane.add(lblJogador);
		
		JLabel lblAcertos = new JLabel("Acertos: "+ certas );
		lblAcertos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAcertos.setForeground(Color.WHITE);
		lblAcertos.setBounds(146, 66, 86, 18);
		contentPane.add(lblAcertos);

		JLabel lblErros = new JLabel("Erros: "+ erradas );
		lblErros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErros.setForeground(Color.WHITE);
		lblErros.setBounds(229, 66, 77, 18);
		contentPane.add(lblErros);
		
		JLabel lblResultado = new JLabel("Testes Feitos: "+testesfeitos);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setBounds(142, 105, 150, 18);
		contentPane.add(lblResultado);
		
		JLabel lblPorcetagem = new JLabel(porcetagem+"%");
		lblPorcetagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorcetagem.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblPorcetagem.setForeground(Color.WHITE);
		lblPorcetagem.setBounds(0, 152, 434, 38);
		contentPane.add(lblPorcetagem);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(FimJogo.class.getResource("/com/javalingo/img/Icones/voltar2.png")));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setFocusable(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(30, 144, 255));
		btnVoltar.setBounds(10, 232, 58, 18);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PontuacaoIndividual.class.getResource("/com/javalingo/img/Imagens/fundo3.jpg")));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
	}
}
