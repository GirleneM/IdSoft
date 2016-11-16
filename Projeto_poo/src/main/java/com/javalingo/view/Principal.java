package com.javalingo.view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;

import com.javalingo.model.Questao;
import com.javalingo.repository.QuestaoDAO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String String = null;
	private JPanel contentPane;
	int certas = 0;
	int erradas = 0;
	int telas = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(String, String);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal(String nomeUser, String idUser) {
		setTitle("Javalingo - Opções");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		UIManager.put("OptionPane.noButtonText", "Difícil");
		UIManager.put("OptionPane.yesButtonText", "Fácil");

		JLabel lblLogado = new JLabel("Bem Vindo, " + nomeUser);
		lblLogado.setForeground(Color.WHITE);
		lblLogado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogado.setBounds(10, 7, 196, 19);
		contentPane.add(lblLogado);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogout.setBorderPainted(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setFocusPainted(false);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = JOptionPane.showConfirmDialog(null, "Deseja Sair?", "Selecione uma Opção",
						JOptionPane.OK_CANCEL_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Deslogado com Sucesso!", "Deslogado!",
							JOptionPane.INFORMATION_MESSAGE);
					TelaInicial ti = new TelaInicial();
					ti.setVisible(true);
					dispose();

				} else if (i == JOptionPane.NO_OPTION) {
				}
			}
		});
		btnLogout.setIcon(new ImageIcon(Principal.class.getResource("/com/javalingo/img/Icones/logout2.png")));
		btnLogout.setBounds(322, 7, 102, 23);
		contentPane.add(btnLogout);

		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.setIcon(new ImageIcon(Principal.class.getResource("/com/javalingo/img/Icones/tutorial2.png")));
		btnTutorial.setForeground(Color.WHITE);
		btnTutorial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTutorial.setBorderPainted(false);
		btnTutorial.setContentAreaFilled(false);
		btnTutorial.setFocusPainted(false);
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tutorial t = new Tutorial(nomeUser, idUser);
				t.setVisible(true);
				dispose();
			}
		});
		btnTutorial.setBounds(174, 207, 102, 23);
		contentPane.add(btnTutorial);

		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			@Autowired
			public void actionPerformed(ActionEvent arg0) {
				int i = JOptionPane.showConfirmDialog(null, "Selecione o Nível", "Jogar!", JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					String facil = "Fácil";
					telas++;
					String tela = Integer.toString(telas);
					QuestaoDAO questaoDAO = new QuestaoDAO();
					Questao questao = new Questao();
					questao = questaoDAO.Novaquestao(facil, "0");
					if (QuestaoDAO.NovaQuestao) {
						String s = questao.setQuestaofeita("1");
						long id = certas;
						String certa = Long.toString(id);
						long id2 = erradas;
						String errada = Long.toString(id2);
						Jogo j = new Jogo(facil, questao.getQuestao(), questao.getResposta(), questao.getAltA(),
								questao.getAltB(), questao.getAltC(), questao.getAltD(), s, idUser, nomeUser, certa, errada, tela);
						j.setVisible(true);
						dispose();
						questao.setQuestaofeita("1");
						questaoDAO.alterar(questao);
					}

				} else if (i == JOptionPane.NO_OPTION) {
					String dificil = "Difícil";
					telas++;
					String tela = Integer.toString(telas);
					QuestaoDAO questaoDAO = new QuestaoDAO();
					Questao questao = new Questao();
					questao = questaoDAO.Novaquestao(dificil, "0");
					if (QuestaoDAO.NovaQuestao) {
						String s = questao.setQuestaofeita("1");
						long id = certas;
						String certa = Long.toString(id);
						long id2 = erradas;
						String errada = Long.toString(id2);
						Jogo j = new Jogo(dificil, questao.getQuestao(), questao.getResposta(), questao.getAltA(),
								questao.getAltB(), questao.getAltC(), questao.getAltD(), s, idUser, nomeUser, certa, errada, tela);
						j.setVisible(true);
						dispose();
						questao.setQuestaofeita("1");
						questaoDAO.alterar(questao);
					}

				}
			}
		});
		btnJogar.setIcon(new ImageIcon(Principal.class.getResource("/com/javalingo/img/Icones/play2.png")));
		btnJogar.setForeground(Color.WHITE);
		btnJogar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnJogar.setBorderPainted(false);
		btnJogar.setContentAreaFilled(false);
		btnJogar.setFocusPainted(false);
		btnJogar.setBounds(174, 173, 102, 23);
		contentPane.add(btnJogar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/com/javalingo/img/Imagens/fundo2.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	}

	public void play(String nomedoaudio) {
		URL url = getClass().getResource(nomedoaudio + ".wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}

}
