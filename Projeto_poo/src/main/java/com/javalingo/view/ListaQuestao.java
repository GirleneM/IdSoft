package com.javalingo.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.javalingo.repository.QuestaoDAO;
import com.javalingo.tableModel.QuestaoTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ListaQuestao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	private void PreencherTabela() {
		QuestaoDAO qd = new QuestaoDAO();
		QuestaoTableModel qtm = new QuestaoTableModel(qd.lista());
		table.setModel(qtm);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaQuestao frame = new ListaQuestao();
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
	public ListaQuestao() {
		setTitle("Javalingo - Lista de Questões");
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
		
		JLabel lblListaDeQuestoes = new JLabel("Lista de Questões");
		lblListaDeQuestoes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeQuestoes.setForeground(Color.WHITE);
		lblListaDeQuestoes.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeQuestoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaDeQuestoes.setBounds(156, 11, 120, 28);
		contentPane.add(lblListaDeQuestoes);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBounds(10, 50, 414, 143);
		contentPane.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 36, 414, 180);
		contentPane.add(scrollPane);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBorder(null);
		btnVoltar.setFocusable(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBackground(new Color(100, 149, 237));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalAdmin pa = new PrincipalAdmin();
				pa.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon("C:\\img\\Icones\\voltar2.png"));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\img\\Imagens\\fundo3.jpg"));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
		PreencherTabela();
	}
}
