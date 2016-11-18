package com.javalingo.view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class Certificado extends JFrame {

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
					Certificado frame = new Certificado(String, String, String);
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
	public Certificado(String nome, String difi, String por) {
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
		
		JLabel lblCertificamosQue = new JLabel("Certificamos que");
		lblCertificamosQue.setFont(new Font("Papyrus", Font.PLAIN, 14));
		lblCertificamosQue.setBounds(79, 78, 119, 14);
		contentPane.add(lblCertificamosQue);
		
		JLabel lblFezOTeste = new JLabel("Fez o teste javalingo no nivel");
		lblFezOTeste.setFont(new Font("Papyrus", Font.PLAIN, 14));
		lblFezOTeste.setBounds(79, 103, 185, 14);
		contentPane.add(lblFezOTeste);
		
		JLabel label_1 = new JLabel(nome);
		label_1.setFont(new Font("Papyrus", Font.PLAIN, 14));
		label_1.setBounds(198, 78, 203, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(difi);
		label_2.setFont(new Font("Papyrus", Font.PLAIN, 14));
		label_2.setBounds(265, 103, 136, 14);
		contentPane.add(label_2);
		
		JLabel lblEConseguiuTaxa = new JLabel("E conseguiu taxa de acerto de");
		lblEConseguiuTaxa.setFont(new Font("Papyrus", Font.PLAIN, 14));
		lblEConseguiuTaxa.setBounds(79, 129, 203, 14);
		contentPane.add(lblEConseguiuTaxa);
		
		JLabel label_4 = new JLabel("________________________________");
		label_4.setBounds(134, 205, 233, 14);
		contentPane.add(label_4);
		
		JLabel label_3 = new JLabel(por);
		label_3.setFont(new Font("Papyrus", Font.PLAIN, 14));
		label_3.setBounds(275, 129, 126, 14);
		contentPane.add(label_3);
		
		JLabel lblNomeDoCertificado = new JLabel("Nome do Certificado");
		lblNomeDoCertificado.setFont(new Font("Papyrus", Font.PLAIN, 14));
		lblNomeDoCertificado.setBounds(168, 221, 146, 14);
		contentPane.add(lblNomeDoCertificado);
		
		JLabel label_5 = new JLabel(nome);
		label_5.setFont(new Font("Papyrus", Font.PLAIN, 14));
		label_5.setBounds(152, 196, 203, 14);
		contentPane.add(label_5);
		
		JLabel lblCertificado = new JLabel("Certificado");
		lblCertificado.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblCertificado.setBounds(168, 31, 92, 26);
		contentPane.add(lblCertificado);
		
		JLabel lblCertificadoNoVlido = new JLabel("Certificado não Válido para uso externo");
		lblCertificadoNoVlido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCertificadoNoVlido.setBounds(10, 247, 414, 14);
		contentPane.add(lblCertificadoNoVlido);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Certificado.class.getResource("/com/javalingo/img/Imagens/cer.png")));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
	}
}
