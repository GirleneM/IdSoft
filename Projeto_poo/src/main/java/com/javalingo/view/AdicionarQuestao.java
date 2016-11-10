package com.javalingo.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import com.javalingo.model.Questao;
import com.javalingo.repository.QuestaoDAO;
import com.javalingo.repository.DAO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class AdicionarQuestao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ctQuestao;
	private JTextField ctRespA;
	private JTextField ctRespB;
	private JTextField ctRespC;
	private JTextField ctRespD;
	private Questao questao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarQuestao frame = new AdicionarQuestao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	{
		this.questao = new Questao();
	}

	/**
	 * Create the frame.
	 */

	public AdicionarQuestao() {
		setTitle("Javalingo - Adicionar Questão");
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

		JLabel lblQuestao = new JLabel("Questão");
		lblQuestao.setForeground(Color.WHITE);
		lblQuestao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuestao.setBounds(188, 0, 62, 24);
		contentPane.add(lblQuestao);

		ctQuestao = new JTextField();
		ctQuestao.setBounds(10, 25, 414, 60);
		contentPane.add(ctQuestao);
		ctQuestao.setColumns(10);

		JLabel lblDificuldade = new JLabel("Dificuldade:");
		lblDificuldade.setForeground(Color.WHITE);
		lblDificuldade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDificuldade.setBounds(10, 90, 95, 24);
		contentPane.add(lblDificuldade);

		JRadioButton difiFacil = new JRadioButton("Fácil");
		difiFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		difiFacil.setBackground(new Color(90, 155, 213));
		difiFacil.setForeground(Color.WHITE);
		difiFacil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		difiFacil.setBounds(92, 91, 51, 23);
		contentPane.add(difiFacil);

		JRadioButton difiDificil = new JRadioButton("Difícil");
		difiDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		difiDificil.setBackground(new Color(90, 155, 213));
		difiDificil.setForeground(Color.WHITE);
		difiDificil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		difiDificil.setBounds(156, 90, 55, 23);
		contentPane.add(difiDificil);

		ButtonGroup bp = new javax.swing.ButtonGroup();
		{

			bp.add(difiFacil);
			bp.add(difiDificil);
		}
		JLabel lblAlternativaCorreta = new JLabel("Alternativas");
		lblAlternativaCorreta.setForeground(Color.WHITE);
		lblAlternativaCorreta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlternativaCorreta.setBounds(176, 112, 81, 24);
		contentPane.add(lblAlternativaCorreta);

		JRadioButton respA = new JRadioButton("A");
		respA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respA.setBackground(new Color(90, 155, 213));
		respA.setForeground(Color.WHITE);
		respA.setBounds(6, 139, 41, 23);
		contentPane.add(respA);

		JRadioButton respB = new JRadioButton("B");
		respB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respB.setBackground(new Color(90, 155, 213));
		respB.setForeground(Color.WHITE);
		respB.setBounds(6, 159, 41, 23);
		contentPane.add(respB);

		JRadioButton respC = new JRadioButton("C");
		respC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respC.setBackground(new Color(90, 155, 213));
		respC.setForeground(Color.WHITE);
		respC.setBounds(6, 179, 41, 23);
		contentPane.add(respC);

		JRadioButton respD = new JRadioButton("D");
		respD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respD.setBackground(new Color(90, 155, 213));
		respD.setForeground(Color.WHITE);
		respD.setBounds(6, 199, 41, 23);
		contentPane.add(respD);

		ButtonGroup bp2 = new javax.swing.ButtonGroup();
		{

			bp2.add(respA);
			bp2.add(respB);
			bp2.add(respC);
			bp2.add(respD);
		}
		JButton btnSalvar = new JButton("Salvar ");
		btnSalvar.setBorderPainted(false);
		btnSalvar.setContentAreaFilled(false);
		btnSalvar.setFocusPainted(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Questao q = new Questao();
				if (!ctQuestao.getText().isEmpty()) {
					q.setQuestao(ctQuestao.getText().toString());
					if(difiFacil.isSelected()) {
						q.setDificuldade(difiFacil.getActionCommand().toString());
					} else {
						q.setDificuldade(difiDificil.getActionCommand().toString());
					}
					if (respA.isSelected()) {
						q.setResposta(respA.getActionCommand().toString());
					} else if (respB.isSelected()) {
						q.setResposta(respB.getActionCommand().toString());
					} else if (respC.isSelected()) {
						q.setResposta(respC.getActionCommand().toString());
					} else {
						q.setResposta(respD.getActionCommand().toString());
					}
					
					q.setAltA(ctRespA.getText().toString());
					q.setAltB(ctRespB.getText().toString());
					q.setAltC(ctRespC.getText().toString());
					q.setAltD(ctRespD.getText().toString());

					DAO<Questao> dao = new QuestaoDAO();
					if (dao.salvar(q)) {
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Sucesso!",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
						PrincipalAdmin pa = new PrincipalAdmin();
						pa.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Falha ao cadadstar!", "Falha!", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Falha!",
							JOptionPane.ERROR_MESSAGE);
					ctQuestao.requestFocus();
				}
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBackground(new Color(100, 149, 237));
		btnSalvar.setIcon(new ImageIcon(AdicionarQuestao.class.getResource("/com/javalingo/img/Icones/salvar2.png")));
		btnSalvar.setBounds(323, 227, 101, 23);
		contentPane.add(btnSalvar);

		JButton btnVoltar = new JButton("Voltar\r\n");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrincipalAdmin pa = new PrincipalAdmin();
				pa.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(AdicionarQuestao.class.getResource("/com/javalingo/img/Icones/voltar2.png")));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBackground(new Color(100, 149, 237));
		btnVoltar.setBounds(10, 227, 101, 23);
		contentPane.add(btnVoltar);
		
		ctRespB = new JTextField();
		ctRespB.setBounds(45, 160, 379, 20);
		contentPane.add(ctRespB);
		ctRespB.setColumns(10);
		
		ctRespA = new JTextField();
		ctRespA.setBounds(45, 140, 379, 20);
		contentPane.add(ctRespA);
		ctRespA.setColumns(10);
		
		ctRespD = new JTextField();
		ctRespD.setBounds(45, 200, 379, 20);
		contentPane.add(ctRespD);
		ctRespD.setColumns(10);
		
		ctRespC = new JTextField();
		ctRespC.setBounds(45, 180, 379, 20);
		contentPane.add(ctRespC);
		ctRespC.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdicionarQuestao.class.getResource("/com/javalingo/img/Imagens/fundo3.jpg")));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
		
	}
	AdicionarQuestao(Questao questao) {		
        
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

		JLabel lblQuestao = new JLabel("Questão");
		lblQuestao.setForeground(Color.WHITE);
		lblQuestao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuestao.setBounds(188, 0, 62, 24);
		contentPane.add(lblQuestao);

		ctQuestao = new JTextField();
		ctQuestao.setBounds(10, 25, 414, 60);
		contentPane.add(ctQuestao);
		ctQuestao.setColumns(10);

		JLabel lblDificuldade = new JLabel("Dificuldade:");
		lblDificuldade.setForeground(Color.WHITE);
		lblDificuldade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDificuldade.setBounds(10, 90, 95, 24);
		contentPane.add(lblDificuldade);

		JRadioButton difiFacil = new JRadioButton("Fácil");
		difiFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		difiFacil.setBackground(new Color(90, 155, 213));
		difiFacil.setForeground(Color.WHITE);
		difiFacil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		difiFacil.setBounds(92, 91, 51, 23);
		contentPane.add(difiFacil);

		JRadioButton difiDificil = new JRadioButton("Difícil");
		difiDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		difiDificil.setBackground(new Color(90, 155, 213));
		difiDificil.setForeground(Color.WHITE);
		difiDificil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		difiDificil.setBounds(156, 90, 55, 23);
		contentPane.add(difiDificil);

		ButtonGroup bp = new javax.swing.ButtonGroup();
		{

			bp.add(difiFacil);
			bp.add(difiDificil);
		}
		JLabel lblAlternativaCorreta = new JLabel("Alternativas");
		lblAlternativaCorreta.setForeground(Color.WHITE);
		lblAlternativaCorreta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlternativaCorreta.setBounds(176, 112, 81, 24);
		contentPane.add(lblAlternativaCorreta);

		JRadioButton respA = new JRadioButton("A");
		respA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respA.setBackground(new Color(90, 155, 213));
		respA.setForeground(Color.WHITE);
		respA.setBounds(6, 139, 41, 23);
		contentPane.add(respA);

		JRadioButton respB = new JRadioButton("B");
		respB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respB.setBackground(new Color(90, 155, 213));
		respB.setForeground(Color.WHITE);
		respB.setBounds(6, 159, 41, 23);
		contentPane.add(respB);

		JRadioButton respC = new JRadioButton("C");
		respC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respC.setBackground(new Color(90, 155, 213));
		respC.setForeground(Color.WHITE);
		respC.setBounds(6, 179, 41, 23);
		contentPane.add(respC);

		JRadioButton respD = new JRadioButton("D");
		respD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respD.setBackground(new Color(90, 155, 213));
		respD.setForeground(Color.WHITE);
		respD.setBounds(6, 199, 41, 23);
		contentPane.add(respD);

		ButtonGroup bp2 = new javax.swing.ButtonGroup();
		{

			bp2.add(respA);
			bp2.add(respB);
			bp2.add(respC);
			bp2.add(respD);
		}
		JButton btnSalvar = new JButton("Salvar ");
		btnSalvar.setBorderPainted(false);
		btnSalvar.setContentAreaFilled(false);
		btnSalvar.setFocusPainted(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!ctQuestao.getText().isEmpty()) {
					questao.setQuestao(ctQuestao.getText().toString());
					if(difiFacil.isSelected()) {
						questao.setDificuldade(difiFacil.getActionCommand().toString());
					} else {
						questao.setDificuldade(difiDificil.getActionCommand().toString());
					}
					if (respA.isSelected()) {
						questao.setResposta(respA.getActionCommand().toString());
					} else if (respB.isSelected()) {
						questao.setResposta(respB.getActionCommand().toString());
					} else if (respC.isSelected()) {
						questao.setResposta(respC.getActionCommand().toString());
					} else {
						questao.setResposta(respD.getActionCommand().toString());
					}
					
					questao.setAltA(ctRespA.getText().toString());
					questao.setAltB(ctRespB.getText().toString());
					questao.setAltC(ctRespC.getText().toString());
					questao.setAltD(ctRespD.getText().toString());

					DAO<Questao> dao = new QuestaoDAO();
					if (dao.alterar(questao)) {
						JOptionPane.showMessageDialog(null, "Questão alterada com sucesso!", "Sucesso!",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
						PrincipalAdmin pa = new PrincipalAdmin();
						pa.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Falha ao Alterar!", "Falha!", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Falha!",
							JOptionPane.ERROR_MESSAGE);
					ctQuestao.requestFocus();
				}
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBackground(new Color(100, 149, 237));
		btnSalvar.setIcon(new ImageIcon(AdicionarQuestao.class.getResource("/com/javalingo/img/Icones/salvar2.png")));
		btnSalvar.setBounds(323, 227, 101, 23);
		contentPane.add(btnSalvar);

		JButton btnVoltar = new JButton("Voltar\r\n");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrincipalAdmin pa = new PrincipalAdmin();
				pa.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(AdicionarQuestao.class.getResource("/com/javalingo/img/Icones/voltar2.png")));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBackground(new Color(100, 149, 237));
		btnVoltar.setBounds(10, 227, 101, 23);
		contentPane.add(btnVoltar);
		
		ctRespB = new JTextField();
		ctRespB.setBounds(45, 160, 379, 20);
		contentPane.add(ctRespB);
		ctRespB.setColumns(10);
		
		ctRespA = new JTextField();
		ctRespA.setBounds(45, 140, 379, 20);
		contentPane.add(ctRespA);
		ctRespA.setColumns(10);
		
		ctRespD = new JTextField();
		ctRespD.setBounds(45, 200, 379, 20);
		contentPane.add(ctRespD);
		ctRespD.setColumns(10);
		
		ctRespC = new JTextField();
		ctRespC.setBounds(45, 180, 379, 20);
		contentPane.add(ctRespC);
		ctRespC.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdicionarQuestao.class.getResource("/com/javalingo/img/Imagens/fundo3.jpg")));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
		
       setTitle("Editar Questao: " + questao.getIdQuestao());
       ctQuestao.setText(questao.getQuestao());
       ctRespA.setText(questao.getAltA());
       ctRespB.setText(questao.getAltB());
       ctRespC.setText(questao.getAltC());
       ctRespD.setText(questao.getAltD());
       this.questao = questao;
       
       
	}
}
