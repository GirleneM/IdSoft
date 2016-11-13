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
		lblListaDeQuestoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaDeQuestoes.setBounds(314, 11, 120, 28);
		contentPane.add(lblListaDeQuestoes);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBounds(10, 50, 414, 143);
		contentPane.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 36, 714, 295);
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
		btnVoltar.setIcon(new ImageIcon(ListaQuestao.class.getResource("/com/javalingo/img/Icones/voltar2.png")));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 527, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBorder(null);
		btnApagar.setFocusable(false);
		btnApagar.setContentAreaFilled(false);
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = table.getSelectedRow();
			    
			    if(linha<0){
			        JOptionPane.showMessageDialog(null, "Selecione uma Questão!", "Erro!", JOptionPane.ERROR_MESSAGE);
			      }
			    else{
			        
			        Object o = table.getValueAt(linha, 0);
			        QuestaoDAO qd = new QuestaoDAO();
			        Questao q = qd.listar("id", (long) o).get(0);
			        
			         if(JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir?", "Excluir", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) 
			    
			    {
			    JOptionPane.showMessageDialog(rootPane, "Questão excluída com sucesso!");
			      qd.remover(q);
			      PreencherTabela();
			      }
			       }
			   
			}
		});
		btnApagar.setForeground(Color.WHITE);
		btnApagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnApagar.setIcon(new ImageIcon(ListaQuestao.class.getResource("/com/javalingo/img/Icones/eraser.png")));
		btnApagar.setBounds(130, 529, 109, 23);
		contentPane.add(btnApagar);
		
		JButton btnCriarQuesto = new JButton("Criar Questão");
		btnCriarQuesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarQuestao aq = new AdicionarQuestao();
				aq.setVisible(true);
				dispose();
			}
		});
		btnCriarQuesto.setIcon(new ImageIcon(ListaQuestao.class.getResource("/com/javalingo/img/Icones/plus (1).png")));
		btnCriarQuesto.setForeground(Color.WHITE);
		btnCriarQuesto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarQuesto.setFocusable(false);
		btnCriarQuesto.setContentAreaFilled(false);
		btnCriarQuesto.setBorder(null);
		btnCriarQuesto.setBounds(262, 529, 120, 23);
		contentPane.add(btnCriarQuesto);
		
		JButton btnAlterarQuesto = new JButton("Alterar Questão");
		btnAlterarQuesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       int linha = table.getSelectedRow();
			        
			        if(linha <0){
			         JOptionPane.showMessageDialog(null, "Selecione um registro!", "Erro!", JOptionPane.ERROR_MESSAGE);
			        }
			        else{
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
		btnAlterarQuesto.setIcon(new ImageIcon(ListaQuestao.class.getResource("/com/javalingo/img/Icones/edit (2).png")));
		btnAlterarQuesto.setForeground(Color.WHITE);
		btnAlterarQuesto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterarQuesto.setFocusable(false);
		btnAlterarQuesto.setContentAreaFilled(false);
		btnAlterarQuesto.setBorder(null);
		btnAlterarQuesto.setBounds(413, 529, 127, 23);
		contentPane.add(btnAlterarQuesto);
		
		JButton btnPesquisar = new JButton("Pesquisar Questão");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ctPesquisar.getText().isEmpty()){
		            JOptionPane.showMessageDialog(null, "Preencha o campo!", "Falha", JOptionPane.ERROR_MESSAGE);
		        }
		        else{
		            QuestaoDAO qd = new QuestaoDAO();
		            QuestaoTableModel qtm = new QuestaoTableModel(qd.listar("questao", ctPesquisar.getText()));
		            table.setModel(qtm);
		        }
			}
		});
		btnPesquisar.setIcon(new ImageIcon(ListaQuestao.class.getResource("/com/javalingo/img/Icones/musica-searcher.png")));
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setFocusable(false);
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setBorder(null);
		btnPesquisar.setBounds(571, 529, 140, 23);
		contentPane.add(btnPesquisar);
		
		ctPesquisar = new JTextField();
		ctPesquisar.setBounds(572, 498, 140, 20);
		contentPane.add(ctPesquisar);
		ctPesquisar.setColumns(10);
		
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
		btnRefresh.setBounds(597, 11, 127, 23);
		contentPane.add(btnRefresh);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(ListaQuestao.class.getResource("/com/javalingo/img/Imagens/fundo 4.jpg")));
		lblFundo.setBounds(0, 0, 734, 561);
		contentPane.add(lblFundo);
		PreencherTabela();
	}
}
