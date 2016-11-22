package com.javalingo.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.javalingo.model.Questao;
import com.javalingo.repository.QuestaoDAO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

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
					Jogo frame = new Jogo(String, String, String, String, String, String, String, String, String,
							String, String, String, String);
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

	public Jogo(String dificuldade, String questao, String resposta, String altA, String altB, String altC, String altD,
			String idQuestao, String idUser, String nomeUser, String certas, String erradas, String tela) {
		setTitle("Javalingo - Questão " + tela + " - " + dificuldade);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int WIDTH = 750;
		int HEIGHT = 480;
		int x = (screen.width - WIDTH) / 2;
		int y = (screen.height - HEIGHT) / 2;
		setBounds(x, y, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		UIManager.put("OptionPane.noButtonText", "Não");
		UIManager.put("OptionPane.yesButtonText", "Desistir");

		JLabel lblQuestao = new JLabel("<html><p align = center>" + questao + "</p></html>");
		lblQuestao.setForeground(new Color(54, 74, 114));
		lblQuestao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuestao.setBounds(73, 21, 256, 362);
		contentPane.add(lblQuestao);

		JButton btnAltA = new JButton("<html>" + altA + "</html>");
		btnAltA.setBackground(new Color(54, 74, 114));
		btnAltA.setBorderPainted(false);
		btnAltA.setFocusPainted(false);
		btnAltA.setForeground(Color.WHITE);
		btnAltA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltA.setBounds(437, 30, 200, 70);
		contentPane.add(btnAltA);
		btnAltA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (resposta.equals("A")) {
					int telas = Integer.valueOf(tela).intValue();
					telas++;
					String te = Integer.toString(telas);
					JOptionPane.showMessageDialog(null, "Correta!");
					long id = Long.parseLong(certas);
					id++;
					String certa = Long.toString(id);
					proxima(dificuldade, idUser, nomeUser, certa, erradas, te);
				} else {
					int telas = Integer.valueOf(tela).intValue();
					telas++;
					String te = Integer.toString(telas);
					JOptionPane.showMessageDialog(null, "Errada!");
					long id2 = Long.parseLong(erradas);
					id2++;
					String errada = Long.toString(id2);
					proxima(dificuldade, idUser, nomeUser, certas, errada, te);

				}
			}
		});

		JButton btnAltB = new JButton("<html>" + altB + "</html>");
		btnAltB.setBackground(new Color(54, 74, 114));
		btnAltB.setBorderPainted(false);
		btnAltB.setFocusPainted(false);
		btnAltB.setForeground(Color.WHITE);
		btnAltB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltB.setBounds(437, 134, 200, 70);
		contentPane.add(btnAltB);
		btnAltB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (resposta.equals("B")) {
					int telas = Integer.valueOf(tela).intValue();
					telas++;
					String te = Integer.toString(telas);
					JOptionPane.showMessageDialog(null, "Correta!");
					long id = Long.parseLong(certas);
					id++;
					String certa = Long.toString(id);
					proxima(dificuldade, idUser, nomeUser, certa, erradas, te);
				} else {
					int telas = Integer.valueOf(tela).intValue();
					telas++;
					String te = Integer.toString(telas);
					JOptionPane.showMessageDialog(null, "Errada!");
					long id2 = Long.parseLong(erradas);
					id2++;
					String errada = Long.toString(id2);
					proxima(dificuldade, idUser, nomeUser, certas, errada, te);

				}
			}
		});

		JButton btnAltC = new JButton("<html>" + altC + "</html>");
		btnAltC.setBackground(new Color(54, 74, 114));
		btnAltC.setBorderPainted(false);
		btnAltC.setFocusPainted(false);
		btnAltC.setForeground(Color.WHITE);
		btnAltC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltC.setBounds(437, 238, 200, 70);
		contentPane.add(btnAltC);
		btnAltC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (resposta.equals("C")) {
					int telas = Integer.valueOf(tela).intValue();
					telas++;
					String te = Integer.toString(telas);
					JOptionPane.showMessageDialog(null, "Correta!");
					long id = Long.parseLong(certas);
					id++;
					String certa = Long.toString(id);
					proxima(dificuldade, idUser, nomeUser, certa, erradas, te);
				} else {
					int telas = Integer.valueOf(tela).intValue();
					telas++;
					String te = Integer.toString(telas);
					JOptionPane.showMessageDialog(null, "Errada!");
					long id2 = Long.parseLong(erradas);
					id2++;
					String errada = Long.toString(id2);
					proxima(dificuldade, idUser, nomeUser, certas, errada, te);

				}
			}
		});

		JButton btnAltD = new JButton("<html>" + altD + "</html>");
		btnAltD.setBackground(new Color(54, 74, 114));
		btnAltD.setBorderPainted(false);
		btnAltD.setFocusPainted(false);
		btnAltD.setForeground(Color.WHITE);
		btnAltD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltD.setBounds(437, 341, 200, 70);
		contentPane.add(btnAltD);
		btnAltD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (resposta.equals("D")) {
					int telas = Integer.valueOf(tela).intValue();
					telas++;
					String te = Integer.toString(telas);
					JOptionPane.showMessageDialog(null, "Correta!");
					long id = Long.parseLong(certas);
					id++;
					String certa = Long.toString(id);
					proxima(dificuldade, idUser, nomeUser, certa, erradas, te);
				} else {
					int telas = Integer.valueOf(tela).intValue();
					telas++;
					String te = Integer.toString(telas);
					JOptionPane.showMessageDialog(null, "Errada!");
					long id2 = Long.parseLong(erradas);
					id2++;
					String errada = Long.toString(id2);
					proxima(dificuldade, idUser, nomeUser, certas, errada, te);

				}
			}
		});

		JButton btnDesistir = new JButton("Desistir");
		btnDesistir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair? Todo jogo feito será apagado",
						"Desistir?", JOptionPane.OK_CANCEL_OPTION);

				if (i == JOptionPane.OK_OPTION) {
					Principal p = new Principal(nomeUser, idUser);
					p.setVisible(true);
					dispose();
					@SuppressWarnings("unused")
					Questao q = new Questao();
					QuestaoDAO qd = new QuestaoDAO();
					q = qd.Zerarquestoes();

					if (QuestaoDAO.zerarquestoes) {
					}

				} else {

				}

				;

			}
		});
		btnDesistir.setIcon(new ImageIcon(Jogo.class.getResource("/com/javalingo/img/Icones/cross (1).png")));
		btnDesistir.setForeground(Color.BLACK);
		btnDesistir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDesistir.setFocusable(false);
		btnDesistir.setContentAreaFilled(false);
		btnDesistir.setBorder(null);
		btnDesistir.setBackground(new Color(30, 144, 255));
		btnDesistir.setBounds(42, 394, 66, 18);
		contentPane.add(btnDesistir);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Jogo.class.getResource("/com/javalingo/img/Imagens/livro5.jpg")));
		lblFundo.setBounds(0, 0, 734, 441);
		contentPane.add(lblFundo);

	}

	public void proxima(String dificuldade, String idUser, String nomeUser, String certas, String erradas,
			String telas) {

		int tela = Integer.valueOf(telas).intValue();

		if (tela < 11) {
			QuestaoDAO questaoDAO = new QuestaoDAO();
			Questao questao = new Questao();
			questao = questaoDAO.Novaquestao(dificuldade, "0");
			if (QuestaoDAO.NovaQuestao) {
				long id = questao.getIdQuestao();
				String idQuestao = Long.toString(id);
				Jogo j1 = new Jogo(dificuldade, questao.getQuestao(), questao.getResposta(), questao.getAltA(),
						questao.getAltB(), questao.getAltC(), questao.getAltD(), idQuestao, idUser, nomeUser, certas,
						erradas, telas);
				j1.setVisible(true);
				dispose();
				questao.setQuestaofeita("1");
				questaoDAO.alterar(questao);
			}
		} else {
			FimJogo fj = new FimJogo(idUser, nomeUser, certas, erradas, dificuldade);
			fj.setVisible(true);
			dispose();
			@SuppressWarnings("unused")
			Questao q = new Questao();
			QuestaoDAO qd = new QuestaoDAO();
			q = qd.Zerarquestoes();
			if (QuestaoDAO.zerarquestoes) {

			}
		}

	}
}
