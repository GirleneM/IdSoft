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
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/javalingo?verifyServerCertificate=false&useSSL=true", "root", "");
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
	
	public static boolean verificauser;

	public Usuario Verificauser(String usuario) {

		Usuario user = new Usuario();

		Connection conn = null;
		Statement consulta = null;
		ResultSet tabela = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/javalingo?verifyServerCertificate=false&useSSL=true", "root", "");
			consulta = conn.createStatement();

			tabela = consulta.executeQuery("SELECT usuario FROM usuario WHERE usuario ='"+usuario+"'");

			if (tabela.next()) {
				
				user.setUsuario(tabela.getString("usuario"));

				verificauser = true;
			} else {
				verificauser = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
		return user;

	}

	public static boolean buscaruser;

	public Usuario Buscaruser(long id) {

		Usuario user = new Usuario();

		Connection conn = null;
		Statement consulta = null;
		ResultSet tabela = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/javalingo?verifyServerCertificate=false&useSSL=true", "root", "");
			consulta = conn.createStatement();

			tabela = consulta.executeQuery("SELECT * FROM usuario WHERE idUsuario ='" + id + "'");

			if (tabela.next()) {
				user.setIdUsuario(tabela.getLong("idUsuario"));
				user.setTestesfeitos(tabela.getString("testesfeitos"));
				user.setQuestaocerta(tabela.getString("questaocerta"));
				user.setQuestaoerrada(tabela.getString("questaoerrada"));
				user.setPorcetagemtotal(tabela.getString("porcetagemtotal"));
				user.setNome(tabela.getString("nome"));
				user.setUsuario(tabela.getString("usuario"));
				user.setEmail(tabela.getString("email"));
				user.setSenha(tabela.getString("senha"));

				buscaruser = true;
			} else {
				buscaruser = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
		return user;

	}

	public static boolean atualizaruser1;

	public Usuario Atualizaruser1(String porcetagemtotal, String questaoerrada, String questaocerta,
			String testesfeitos, long id) {

		Usuario user = new Usuario();
		Connection conn = null;
		Statement consulta = null;
		Object tabela = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/javalingo?verifyServerCertificate=false&useSSL=true", "root", "");
			consulta = conn.createStatement();

			tabela = consulta.executeUpdate("UPDATE usuario SET porcetagemtotal = '" + porcetagemtotal
					+ "', questaocerta = '" + questaocerta + "', questaoerrada = '" + questaoerrada
					+ "', testesfeitos = '" + testesfeitos + "' WHERE idUsuario = '" + id + "'");

			if (((ResultSet) tabela).next()) {

				user.setPorcetagemtotal(((ResultSet) tabela).getString(porcetagemtotal));
				user.setQuestaocerta(((ResultSet) tabela).getString(questaocerta));
				user.setQuestaoerrada(((ResultSet) tabela).getString(questaoerrada));
				user.setTestesfeitos(((ResultSet) tabela).getString(testesfeitos));

				atualizaruser1 = true;
			} else {
				atualizaruser1 = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
		return user;

	}
	
	public static boolean deletaruser;

	public Usuario Deletaruser(long id) {

		Usuario user = new Usuario();
		Connection conn = null;
		Statement consulta = null;
		Object tabela = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/javalingo?verifyServerCertificate=false&useSSL=true", "root", "");
			consulta = conn.createStatement();

			tabela = consulta.executeUpdate("DELETE FROM usuario WHERE idUsuario = '"+id+"'");

			if (((ResultSet) tabela).next()) {

				user.setIdUsuario(((ResultSet) tabela).getLong("idUsuario"));


				atualizaruser1 = true;
			} else {
				atualizaruser1 = false;
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
