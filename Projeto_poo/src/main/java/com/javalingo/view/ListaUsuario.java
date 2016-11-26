package com.javalingo.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.javalingo.repository.UsuarioDAO;
import com.javalingo.tableModel.UsuarioTableModel;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField ctPesquisar;
	private JButton btnRefresh;

	private void PreencherTabela() {
		UsuarioDAO ud = new UsuarioDAO();
		UsuarioTableModel utm = new UsuarioTableModel(ud.lista());
		table.setModel(utm);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ListaUsuario frame = new ListaUsuario();
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
	public ListaUsuario() {
		setTitle("Javalingo - Lista de Usuários");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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

		JLabel lblListaDeUsuarios = new JLabel("Lista de Usuários");
		lblListaDeUsuarios.setForeground(Color.WHITE);
		lblListaDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaDeUsuarios.setBounds(312, 5, 120, 28);
		contentPane.add(lblListaDeUsuarios);

		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PreencherTabela();

			}
		});
		btnRefresh.setIcon(new ImageIcon(ListaUsuario.class.getResource("/com/javalingo/img/Icones/reload (1).png")));
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRefresh.setFocusable(false);
		btnRefresh.setContentAreaFilled(false);
		btnRefresh.setBorder(null);
		btnRefresh.setBackground(new Color(30, 144, 255));
		btnRefresh.setBounds(656, 10, 68, 18);
		contentPane.add(btnRefresh);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBounds(10, 50, 414, 143);
		contentPane.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 36, 714, 484);
		contentPane.add(scrollPane);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ctPesquisar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo!", "Falha", JOptionPane.ERROR_MESSAGE);
				} else {
					UsuarioDAO ud = new UsuarioDAO();
					UsuarioTableModel utm = new UsuarioTableModel(ud.listar("nome", ctPesquisar.getText()));
					table.setModel(utm);
				}
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PrincipalAdmin pa = new PrincipalAdmin();
				pa.setVisible(true);
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
		btnVoltar.setBounds(10, 531, 58, 18);
		contentPane.add(btnVoltar);
		btnPesquisar.setIcon(
				new ImageIcon(ListaQuestao.class.getResource("/com/javalingo/img/Icones/musica-searcher.png")));
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setFocusable(false);
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setBorder(null);
		btnPesquisar.setBounds(706, 531, 18, 18);
		contentPane.add(btnPesquisar);

		ctPesquisar = new JTextField();
		ctPesquisar.setBounds(554, 531, 142, 20);
		contentPane.add(ctPesquisar);
		ctPesquisar.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ListaUsuario.class.getResource("/com/javalingo/img/Imagens/fundo 4.jpg")));
		label.setBounds(0, 0, 734, 561);
		contentPane.add(label);
		PreencherTabela();
	}
}
