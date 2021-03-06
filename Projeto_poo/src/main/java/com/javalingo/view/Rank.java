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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import com.javalingo.repository.UsuarioDAO;
import com.javalingo.tableModel.RankTableModel;

import javax.swing.JLabel;

public class Rank extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	private void PreencherTabela() {
		UsuarioDAO qd = new UsuarioDAO();
		RankTableModel qtm = new RankTableModel(qd.lista());
		table.setModel(qtm);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rank frame = new Rank();
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
	public Rank() {
		setTitle("Javalingo - Rank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int WIDTH = 750;
		int HEIGHT = 600;
		int x = (screen.width - WIDTH) / 2;
		int y = (screen.height - HEIGHT) / 2;
		setBounds(x, y, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRank = new JLabel("Rank");
		lblRank.setForeground(Color.WHITE);
		lblRank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRank.setBounds(347, 11, 34, 14);
		contentPane.add(lblRank);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBounds(10, 50, 414, 143);
		contentPane.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 36, 714, 244);
		contentPane.add(scrollPane);
		PreencherTabela();
		
		RankTableModel modelo = (RankTableModel) table.getModel();
		table.setRowSorter(new TableRowSorter<>(modelo));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
				dispose();

			}
		});
		btnVoltar.setIcon(new ImageIcon(Tutorial.class.getResource("/com/javalingo/img/Icones/voltar2.png")));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setFocusable(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(30, 144, 255));
		btnVoltar.setBounds(10, 535, 58, 18);
		contentPane.add(btnVoltar);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Rank.class.getResource("/com/javalingo/img/Imagens/fundo 4.jpg")));
		lblFundo.setBounds(0, 0, 734, 561);
		contentPane.add(lblFundo);

	}
}
