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

public class EditarUsuario extends JFrame {

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
	private static final String String = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarUsuario frame = new EditarUsuario(String, String, String, String, String, String, String,
							String, String);
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
	public EditarUsuario(String idUser, String nomeUser, String usuario, String email, String senha, String porcetagem,
			String certas, String erradas, String testesfeitos) {
		setTitle("Javalingo - Editar Usuário");
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

		JLabel lblCadastro = new JLabel("Perfil");
		lblCadastro.setForeground(Color.WHITE);
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastro.setBounds(202, 27, 30, 14);
		contentPane.add(lblCadastro);

		JLabel lblNome = new JLabel("Nome*   :");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 65, 77, 14);
		contentPane.add(lblNome);

		ctNome = new JTextField(nomeUser);
		ctNome.setBounds(88, 64, 336, 20);
		contentPane.add(ctNome);
		ctNome.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuário* :");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(10, 97, 77, 14);
		contentPane.add(lblUsuario);

		ctUsuario = new JTextField(usuario);
		ctUsuario.setBounds(88, 96, 336, 20);
		contentPane.add(ctUsuario);
		ctUsuario.setColumns(10);

		lblEmail = new JLabel("E-mail*   :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 128, 77, 14);
		contentPane.add(lblEmail);

		ctEmail = new JTextField(email);
		ctEmail.setBounds(88, 127, 336, 20);
		contentPane.add(ctEmail);
		ctEmail.setColumns(10);

		lblSenha = new JLabel("Senha*   :");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(10, 159, 77, 14);
		contentPane.add(lblSenha);

		ctSenha = new JPasswordField(senha);
		ctSenha.setBounds(88, 158, 336, 20);
		contentPane.add(ctSenha);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Principal p = new Principal(nomeUser, idUser);
				p.setVisible(true);
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

		JButton btnDeletar = new JButton("Excluir");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long id = Long.parseLong(idUser);
				int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir sua conta?", "Excluir?",
						JOptionPane.OK_CANCEL_OPTION);

				if (i == JOptionPane.OK_OPTION) {
					TelaInicial ti = new TelaInicial();
					ti.setVisible(true);
					dispose();
					@SuppressWarnings("unused")
					Usuario u = new Usuario();
					UsuarioDAO ud = new UsuarioDAO();
					u = ud.Deletaruser(id);
					if (UsuarioDAO.deletaruser) {
					}
				} else {

				}
			}
		});
		btnDeletar.setIcon(new ImageIcon(EditarUsuario.class.getResource("/com/javalingo/img/Icones/trash-can.png")));
		btnDeletar.setForeground(Color.WHITE);
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletar.setFocusable(false);
		btnDeletar.setContentAreaFilled(false);
		btnDeletar.setBorder(null);
		btnDeletar.setBackground(new Color(30, 144, 255));
		btnDeletar.setBounds(186, 232, 62, 18);
		contentPane.add(btnDeletar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Usuario usuario = new Usuario();
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuario = usuarioDAO.Verificauser(ctUsuario.getText());
				if (UsuarioDAO.verificauser) {
					JOptionPane.showMessageDialog(null,
							"Nome de usuário já existente, por favor, altere seu nome de usuário!");
				} else {

					Usuario u = new Usuario();

					if (!ctNome.getText().isEmpty() && !ctUsuario.getText().isEmpty() && !ctEmail.getText().isEmpty()
							&& !ctSenha.getText().isEmpty()) {
						long id = Long.parseLong(idUser);
						u.setIdUsuario(id);
						u.setNome(ctNome.getText().toString());
						u.setUsuario(ctUsuario.getText().toString());
						u.setEmail(ctEmail.getText().toString());
						u.setSenha(ctSenha.getText().toString());
						u.setPorcetagemtotal(porcetagem);
						u.setQuestaocerta(certas);
						u.setQuestaoerrada(erradas);
						u.setTestesfeitos(testesfeitos);

						DAO<Usuario> dao = new UsuarioDAO();

						if (dao.alterar(u)) {
							JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Sucesso!",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
							Login l = new Login();
							l.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Falha ao alterar!", "Falha!",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Falha!",
								JOptionPane.ERROR_MESSAGE);
						ctNome.requestFocus();
					}
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(EditarUsuario.class.getResource("/com/javalingo/img/Icones/salvar2.png")));
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
