package com.javalingo.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalingo.model.Usuario;
import com.javalingo.repository.UsuarioDAO;
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
					FimJogo frame = new FimJogo(String, String, String, String, String);
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

	public FimJogo(String idUser, String nomeUser, String certas, String erradas, String dificuldade) {
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

		JLabel lblJogador = new JLabel("Jogador: " + nomeUser);
		lblJogador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJogador.setForeground(Color.WHITE);
		lblJogador.setBounds(10, 11, 424, 25);
		contentPane_1.add(lblJogador);

		JLabel lblAcertos = new JLabel("Acertos:" + certas);
		lblAcertos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAcertos.setForeground(Color.WHITE);
		lblAcertos.setBounds(10, 70, 158, 14);
		contentPane_1.add(lblAcertos);

		JLabel lblErros = new JLabel("Erros: " + erradas);
		lblErros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErros.setForeground(Color.WHITE);
		lblErros.setBounds(10, 100, 158, 14);
		contentPane_1.add(lblErros);

		double id = Double.valueOf(certas).doubleValue();
		double id2 = Double.valueOf(erradas).doubleValue();
		double porcetagem = 100 / (id + id2) * id;
		String porceta = Double.toString(porcetagem);

		JLabel lblPorcetagem = new JLabel("Porcetagem:" + porcetagem + "%");
		lblPorcetagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorcetagem.setForeground(Color.WHITE);
		lblPorcetagem.setBounds(10, 130, 158, 22);
		contentPane_1.add(lblPorcetagem);

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

				long id = Long.parseLong(idUser);
				Usuario usuario = new Usuario();
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuario = usuarioDAO.Buscaruser(id);

				if (UsuarioDAO.buscaruser) {
					String feitos = usuario.getTestesfeitos();
					String certa = usuario.getQuestaocerta();
					String errada = usuario.getQuestaoerrada();
					String porcen = usuario.getPorcetagemtotal();

					int feito = Integer.valueOf(feitos).intValue();
					int cetotal = Integer.valueOf(certa).intValue();
					int ertotal = Integer.valueOf(errada).intValue();
					double porctotal = Double.valueOf(porcen).doubleValue();

					int ceparcial = Integer.valueOf(certas).intValue();
					int erparcial = Integer.valueOf(erradas).intValue();

					cetotal = cetotal + ceparcial;
					ertotal = ertotal + erparcial;
					double por = (porctotal + porcetagem) / 2;

					String certototal = Integer.toString(cetotal);
					String erradototal = Integer.toString(ertotal);
					String porcetagemparcial = Double.toString(porcetagem);
					String porcetotal = Double.toString(por);

					if (feito < 1) {
						feito++;
						String tefeitos = Integer.toString(feito);
						usuario = usuarioDAO.Atualizaruser1(porcetagemparcial, erradototal, certototal, tefeitos, id);
						if (UsuarioDAO.atualizaruser1) {

						}
					} else {
						feito++;
						String tefeitos = Integer.toString(feito);
						usuario = usuarioDAO.Atualizaruser1(porcetotal, erradototal, certototal, tefeitos, id);
						if (UsuarioDAO.atualizaruser1) {

						}
					}
				} else {

				}
			}
		});
		btnTela.setBounds(94, 227, 256, 23);
		contentPane_1.add(btnTela);
		
		JButton btnObterCertificado = new JButton("Obter Certificado");
		btnObterCertificado.setForeground(Color.WHITE);
		btnObterCertificado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnObterCertificado.setBorderPainted(false);
		btnObterCertificado.setContentAreaFilled(false);
		btnObterCertificado.setFocusPainted(false);
		btnObterCertificado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Certificado c = new  Certificado(nomeUser, dificuldade, porceta+"%");
				c.setVisible(true);
			}
		});
		btnObterCertificado.setBounds(153, 158, 140, 23);
		contentPane_1.add(btnObterCertificado);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(FimJogo.class.getResource("/com/javalingo/img/Imagens/fundo2.jpg")));
		lblFundo.setBounds(0, 0, 434, 261);
		contentPane_1.add(lblFundo);

	}
}
