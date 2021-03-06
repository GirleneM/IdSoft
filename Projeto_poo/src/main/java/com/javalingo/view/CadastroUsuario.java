package com.javalingo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalingo.model.Usuario;
import com.javalingo.repository.UsuarioDAO;
import com.javalingo.repository.DAO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class CadastroUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ctNome;
	private JTextField ctUsuario;
	private JLabel lblEmail;
	private JTextField ctEmail;
	private JLabel lblSenha;
	private JPasswordField ctSenha;
	private JLabel lblFundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
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
	public CadastroUsuario() {
		setTitle("Javalingo - Cadastro");
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

		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setForeground(Color.WHITE);
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastro.setBounds(188, 27, 58, 14);
		contentPane.add(lblCadastro);

		JLabel lblNome = new JLabel("Nome*   :");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 65, 68, 14);
		contentPane.add(lblNome);

		ctNome = new JTextField();
		ctNome.setBounds(88, 64, 336, 20);
		contentPane.add(ctNome);
		ctNome.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuário* :");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(10, 97, 83, 14);
		contentPane.add(lblUsuario);

		ctUsuario = new JTextField();
		ctUsuario.setBounds(88, 96, 336, 20);
		contentPane.add(ctUsuario);
		ctUsuario.setColumns(10);

		lblEmail = new JLabel("E-mail*   :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 128, 83, 14);
		contentPane.add(lblEmail);

		ctEmail = new JTextField();
		ctEmail.setBounds(88, 127, 336, 20);
		contentPane.add(ctEmail);
		ctEmail.setColumns(10);

		lblSenha = new JLabel("Senha*   :");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(10, 159, 83, 14);
		contentPane.add(lblSenha);

		ctSenha = new JPasswordField();
		ctSenha.setBounds(88, 158, 336, 20);
		contentPane.add(ctSenha);

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
		btnVoltar.setBounds(10, 232, 58, 18);
		contentPane.add(btnVoltar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Usuario usuario = new Usuario();
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuario = usuarioDAO.Verificauser(ctUsuario.getText());
				if(UsuarioDAO.verificauser){
				JOptionPane.showMessageDialog(null, "Nome de usuário já existente, por favor, altere seu nome de usuário!");	
				}
				else{
				Usuario u = new Usuario();

				if (!ctNome.getText().isEmpty() && !ctUsuario.getText().isEmpty() && !ctEmail.getText().isEmpty()
						&& !ctSenha.getText().isEmpty()) {
					u.setNome(ctNome.getText().toString());
					u.setUsuario(ctUsuario.getText().toString());
					u.setEmail(ctEmail.getText().toString());
					u.setSenha(ctSenha.getText().toString());
					u.setPorcetagemtotal("0");
					u.setQuestaocerta("0");
					u.setQuestaoerrada("0");
					u.setTestesfeitos("0");

					DAO<Usuario> dao = new UsuarioDAO();
					ctNome.setText(null);
					ctUsuario.setText(null);
					ctEmail.setText(null);
					ctSenha.setText(null);

					if (dao.salvar(u)) {
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Sucesso!",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
						TelaInicial ti = new TelaInicial();
						ti.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Falha ao cadastrar!", "Falha!", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Falha!",
							JOptionPane.ERROR_MESSAGE);
					ctNome.requestFocus();
				}
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/com/javalingo/img/Icones/salvar2.png")));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setFocusable(false);
		btnSalvar.setContentAreaFilled(false);
		btnSalvar.setBorder(null);
		btnSalvar.setBackground(new Color(30, 144, 255));
		btnSalvar.setBounds(360, 232, 60, 18);
		contentPane.add(btnSalvar);
		
		lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/com/javalingo/img/Imagens/fundo3.jpg")));
		lblFundo.setBounds(0, 0, 434, 261);
		contentPane.add(lblFundo);
	}
}
