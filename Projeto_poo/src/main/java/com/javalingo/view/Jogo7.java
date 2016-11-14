package com.javalingo.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalingo.model.Questao;
import com.javalingo.repository.QuestaoDAO;

public class Jogo7 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected static final String String = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo7 frame = new Jogo7(String, String, String, String, String, String, String, String, String, String);
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
	public Jogo7(String dificuldade, String questao, String resposta, String altA, String altB, String altC, String altD, String idQuestao, String idUser, String nomeUser) {
		setTitle("Javalingo - Sétima Questão " + dificuldade);
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
		
		
		JLabel lblQuestao = new JLabel("<html><p align = justify>Questao: " + questao + "</p></html>");
		lblQuestao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuestao.setBounds(35, 11, 172, 203);
		contentPane.add(lblQuestao);
		
		JButton btnAltA = new JButton(altA);
		btnAltA.setBackground(new Color(139, 69, 19));
		btnAltA.setBorderPainted(false);
		btnAltA.setFocusPainted(false);
		btnAltA.setForeground(Color.WHITE);
		btnAltA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltA.setBounds(323, 227, 101, 23);
		contentPane.add(btnAltA);
		btnAltA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(resposta.equals("A")){
					
					JOptionPane.showMessageDialog(null, "Correta!");
					QuestaoDAO questaoDAO = new QuestaoDAO();
					Questao questao = new Questao();
					questao = questaoDAO.Novaquestao(dificuldade, "0");
					if(QuestaoDAO.NovaQuestao){
						long id = questao.getIdQuestao();
						String idQuestao = Long.toString(id);
						Jogo8 j8 = new Jogo8(dificuldade, questao.getQuestao(), questao.getResposta(),
								questao.getAltA(), questao.getAltB(),questao.getAltC(), questao.getAltD(), idQuestao, idUser, nomeUser);
						j8.setVisible(true);
						dispose();
						questao.setQuestaofeita("1");
						questaoDAO.alterar(questao);
						}
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Errada!");
					QuestaoDAO questaoDAO = new QuestaoDAO();
					Questao questao = new Questao();
					questao = questaoDAO.Novaquestao(dificuldade, "0");
					if(QuestaoDAO.NovaQuestao){
						long id = questao.getIdQuestao();
						String idQuestao = Long.toString(id);
						Jogo8 j8 = new Jogo8(dificuldade, questao.getQuestao(), questao.getResposta(),
								questao.getAltA(), questao.getAltB(),questao.getAltC(), questao.getAltD(), idQuestao, idUser, nomeUser);
						j8.setVisible(true);
						dispose();
						questao.setQuestaofeita("1");
						questaoDAO.alterar(questao);
					}
					
				}
			}
		});
		btnAltA.setBounds(233, 34, 156, 23);
		contentPane.add(btnAltA);
		
		JButton btnAltB = new JButton(altB);
		btnAltB.setBackground(new Color(139, 69, 19));
		btnAltB.setBorderPainted(false);
		btnAltB.setFocusPainted(false);
		btnAltB.setForeground(Color.WHITE);
		btnAltB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltB.setBounds(323, 227, 101, 23);
		contentPane.add(btnAltB);
		btnAltB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
if(resposta.equals("B")){
					
					JOptionPane.showMessageDialog(null, "Correta!");
					QuestaoDAO questaoDAO = new QuestaoDAO();
					Questao questao = new Questao();
					questao = questaoDAO.Novaquestao(dificuldade, "0");
					if(QuestaoDAO.NovaQuestao){
						long id = questao.getIdQuestao();
						String idQuestao = Long.toString(id);
						Jogo8 j8 = new Jogo8(dificuldade, questao.getQuestao(), questao.getResposta(),
								questao.getAltA(), questao.getAltB(),questao.getAltC(), questao.getAltD(), idQuestao, idUser, nomeUser);
						j8.setVisible(true);
						dispose();
						questao.setQuestaofeita("1");
						questaoDAO.alterar(questao);
						}
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Errada!");
					QuestaoDAO questaoDAO = new QuestaoDAO();
					Questao questao = new Questao();
					questao = questaoDAO.Novaquestao(dificuldade, "0");
					if(QuestaoDAO.NovaQuestao){
						long id = questao.getIdQuestao();
						String idQuestao = Long.toString(id);
						Jogo8 j8 = new Jogo8(dificuldade, questao.getQuestao(), questao.getResposta(),
								questao.getAltA(), questao.getAltB(),questao.getAltC(), questao.getAltD(), idQuestao, idUser, nomeUser);
						j8.setVisible(true);
						dispose();
						questao.setQuestaofeita("1");
						questaoDAO.alterar(questao);
					}
					
				}
			}
		});
		btnAltB.setBounds(233, 90, 156, 23);
		contentPane.add(btnAltB);
		
		JButton btnAltC = new JButton(altC);
		btnAltC.setBackground(new Color(139, 69, 19));
		btnAltC.setBorderPainted(false);
		btnAltC.setFocusPainted(false);
		btnAltC.setForeground(Color.WHITE);
		btnAltC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltC.setBounds(323, 227, 101, 23);
		contentPane.add(btnAltC);
		btnAltC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
if(resposta.equals("C")){
					
					JOptionPane.showMessageDialog(null, "Correta!");
					QuestaoDAO questaoDAO = new QuestaoDAO();
					Questao questao = new Questao();
					questao = questaoDAO.Novaquestao(dificuldade, "0");
					if(QuestaoDAO.NovaQuestao){
						long id = questao.getIdQuestao();
						String idQuestao = Long.toString(id);
						Jogo8 j8 = new Jogo8(dificuldade, questao.getQuestao(), questao.getResposta(),
								questao.getAltA(), questao.getAltB(),questao.getAltC(), questao.getAltD(), idQuestao, idUser, nomeUser);
						j8.setVisible(true);
						dispose();
						questao.setQuestaofeita("1");
						questaoDAO.alterar(questao);
						}
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Errada!");
					QuestaoDAO questaoDAO = new QuestaoDAO();
					Questao questao = new Questao();
					questao = questaoDAO.Novaquestao(dificuldade, "0");
					if(QuestaoDAO.NovaQuestao){
						long id = questao.getIdQuestao();
						String idQuestao = Long.toString(id);
						Jogo8 j8 = new Jogo8(dificuldade, questao.getQuestao(), questao.getResposta(),
								questao.getAltA(), questao.getAltB(),questao.getAltC(), questao.getAltD(), idQuestao, idUser, nomeUser);
						j8.setVisible(true);
						dispose();
						questao.setQuestaofeita("1");
						questaoDAO.alterar(questao);
					}
					
				}
			}
		});
		btnAltC.setBounds(233, 146, 156, 23);
		contentPane.add(btnAltC);
		
		JButton btnAltD = new JButton(altD);
		btnAltD.setBackground(new Color(139, 69, 19));
		btnAltD.setBorderPainted(false);
		btnAltD.setFocusPainted(false);
		btnAltD.setForeground(Color.WHITE);
		btnAltD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltD.setBounds(323, 227, 101, 23);
		contentPane.add(btnAltD);
		btnAltD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
if(resposta.equals("D")){
					
					JOptionPane.showMessageDialog(null, "Correta!");
					QuestaoDAO questaoDAO = new QuestaoDAO();
					Questao questao = new Questao();
					questao = questaoDAO.Novaquestao(dificuldade, "0");
					if(QuestaoDAO.NovaQuestao){
						long id = questao.getIdQuestao();
						String idQuestao = Long.toString(id);
						Jogo8 j8 = new Jogo8(dificuldade, questao.getQuestao(), questao.getResposta(),
								questao.getAltA(), questao.getAltB(),questao.getAltC(), questao.getAltD(), idQuestao, idUser, nomeUser);
						j8.setVisible(true);
						dispose();
						questao.setQuestaofeita("1");
						questaoDAO.alterar(questao);
						}
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Errada!");
					QuestaoDAO questaoDAO = new QuestaoDAO();
					Questao questao = new Questao();
					questao = questaoDAO.Novaquestao(dificuldade, "0");
					if(QuestaoDAO.NovaQuestao){
						long id = questao.getIdQuestao();
						String idQuestao = Long.toString(id);
						Jogo8 j8 = new Jogo8(dificuldade, questao.getQuestao(), questao.getResposta(),
								questao.getAltA(), questao.getAltB(),questao.getAltC(), questao.getAltD(), idQuestao, idUser, nomeUser);
						j8.setVisible(true);
						dispose();
						questao.setQuestaofeita("1");
						questaoDAO.alterar(questao);
					}
					
				}
			}
		});

		btnAltD.setBounds(233, 202, 156, 23);
		contentPane.add(btnAltD);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Jogo1.class.getResource("/com/javalingo/img/Imagens/livro.png")));
		lblFundo.setBounds(0, 0, 434, 261);
		contentPane.add(lblFundo);
	}

}
