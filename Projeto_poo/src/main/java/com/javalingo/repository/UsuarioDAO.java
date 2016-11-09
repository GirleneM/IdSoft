package com.javalingo.repository;

import com.javalingo.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO extends GenericDAO<Usuario> {

	public static boolean acesso;

	public Usuario Acesso(String usuario, String senha) {

		Usuario user = new Usuario();

		Connection conn = null;
		Statement consulta = null;
		ResultSet tabela = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javalingo", "root", "");
			consulta = conn.createStatement();

			tabela = consulta.executeQuery("SELECT idUsuario, email, nome, senha, usuario from usuario WHERE usuario='"
					+ usuario + "'and senha='" + senha + "'");

			if (tabela.next()) {
				user.setIdUsuario(tabela.getLong("idUsuario"));
				user.setEmail(tabela.getString("email"));
				user.setNome(tabela.getString("nome"));
				user.setSenha(tabela.getString("senha"));
				user.setUsuario(tabela.getString("usuario"));

				acesso = true;
			} else {
				acesso = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
		return user;

	}

	public UsuarioDAO() {
		super(Usuario.class);
	}

}
