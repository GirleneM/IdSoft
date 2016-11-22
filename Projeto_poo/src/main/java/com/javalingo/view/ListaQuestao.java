package com.javalingo.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.javalingo.model.Questao;
import com.javalingo.repository.QuestaoDAO;
import com.javalingo.tableModel.QuestaoTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ListaQuestao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField ctPesquisar;

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
		int WIDTH = 750;
		int HEIGHT = 600;
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
		lblListaDeQuestoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaDeQuestoes.setBounds(307, 5, 120, 28);
		contentPane.add(lblListaDeQuestoes);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PreencherTabela();

			}
		});
		btnRefresh.setIcon(new ImageIcon(ListaQuestao.class.getResource("/com/javalingo/img/Icones/reload (1).png")));
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
		table.setBounds(1, 26, 695, 494);
		contentPane.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 44, 714, 476);
		contentPane.add(scrollPane);

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

		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int linha = table.getSelectedRow();

				if (linha < 0) {
					JOptionPane.showMessageDialog(null, "Selecione uma Questão!", "Erro!", JOptionPane.ERROR_MESSAGE);
				} else {

					Object o = table.getValueAt(linha, 0);
					QuestaoDAO qd = new QuestaoDAO();
					Questao q = qd.listar("id", (long) o).get(0);

					UIManager.put("OptionPane.noButtonText", "Não");
					UIManager.put("OptionPane.yesButtonText", "Sim");
					if (JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir?", "Excluir",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)

					{
						JOptionPane.showMessageDialog(rootPane, "Questão excluída com sucesso!");
						qd.remover(q);
						PreencherTabela();
					}
				}

			}
		});
		btnApagar.setIcon(new ImageIcon(Tutorial.class.getResource("/com/javalingo/img/Icones/eraser.png")));
		btnApagar.setForeground(Color.WHITE);
		btnApagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnApagar.setFocusable(false);
		btnApagar.setContentAreaFilled(false);
		btnApagar.setBorder(null);
		btnApagar.setBackground(new Color(30, 144, 255));
		btnApagar.setBounds(150, 531, 66, 18);
		contentPane.add(btnApagar);

		JButton btnCriarQuestao = new JButton("Nova Questão");
		btnCriarQuestao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdicionarQuestao aq = new AdicionarQuestao();
				aq.setVisible(true);
				dispose();

			}
		});
		btnCriarQuestao.setIcon(new ImageIcon(ListaQuestao.class.getResource("/com/javalingo/img/Icones/plus (1).png")));
		btnCriarQuestao.setForeground(Color.WHITE);
		btnCriarQuestao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarQuestao.setFocusable(false);
		btnCriarQuestao.setContentAreaFilled(false);
		btnCriarQuestao.setBorder(null);
		btnCriarQuestao.setBackground(new Color(30, 144, 255));
		btnCriarQuestao.setBounds(268, 531, 110, 18);
		contentPane.add(btnCriarQuestao);

		JButton btnAlterarQuestao = new JButton("Alterar");
		btnAlterarQuestao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int linha = table.getSelectedRow();

				if (linha < 0) {
					JOptionPane.showMessageDialog(null, "Selecione um registro!", "Erro!", JOptionPane.ERROR_MESSAGE);
				} else {
					Object o = table.getValueAt(linha, 0);
					QuestaoDAO qd = new QuestaoDAO();
					Questao questao = qd.listar("id", (long) o).get(0);
					AdicionarQuestao aq = new AdicionarQuestao(questao);
					aq.setVisible(true);
					dispose();
					PreencherTabela();
				}
			}
		});
		btnAlterarQuestao.setIcon(new ImageIcon(Tutorial.class.getResource("/com/javalingo/img/Icones/edit (2).png")));
		btnAlterarQuestao.setForeground(Color.WHITE);
		btnAlterarQuestao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterarQuestao.setFocusable(false);
		btnAlterarQuestao.setContentAreaFilled(false);
		btnAlterarQuestao.setBorder(null);
		btnAlterarQuestao.setBackground(new Color(30, 144, 255));
		btnAlterarQuestao.setBounds(434, 531, 62, 18);
		contentPane.add(btnAlterarQuestao);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ctPesquisar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo!", "Falha", JOptionPane.ERROR_MESSAGE);
				} else {
					QuestaoDAO qd = new QuestaoDAO();
					QuestaoTableModel qtm = new QuestaoTableModel(qd.listar("questao", ctPesquisar.getText()));
					table.setModel(qtm);
				}

			}
		});
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
		ctPesquisar.setBounds(554, 531, 140, 20);
		contentPane.add(ctPesquisar);
		ctPesquisar.setColumns(10);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(ListaQuestao.class.getResource("/com/javalingo/img/Imagens/fundo 4.jpg")));
		lblFundo.setBounds(0, 0, 734, 561);
		contentPane.add(lblFundo);
		PreencherTabela();
	}
}
