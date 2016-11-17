package com.javalingo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.javalingo.model.Questao;

public class QuestaoDAO extends GenericDAO<Questao> {

	public static boolean NovaQuestao;

	public Questao Novaquestao(String dificuldade, String questaomarcada) {

		Questao questao = new Questao();

		Connection conn = null;
		Statement consulta = null;
		ResultSet tabela = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/javalingo?verifyServerCertificate=false&useSSL=true", "root", "");
			consulta = conn.createStatement();

			tabela = consulta.executeQuery("SELECT * FROM questao WHERE questaofeita='" + questaomarcada
					+ "' and dificuldade='" + dificuldade + "' ORDER BY rand() LIMIT 1");

			if (tabela.next()) {
				questao.setIdQuestao(tabela.getLong("idQuestao"));
				questao.setAltA(tabela.getString("altA"));
				questao.setAltB(tabela.getString("altB"));
				questao.setAltC(tabela.getString("altC"));
				questao.setAltD(tabela.getString("altD"));
				questao.setDificuldade(tabela.getString("dificuldade"));
				questao.setQuestao(tabela.getString("questao"));
				questao.setResposta(tabela.getString("resposta"));

				NovaQuestao = true;
			} else {
				NovaQuestao = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
		return questao;

	}

	public static boolean zerarquestoes;

	public Questao Zerarquestoes() {

		Questao questao = new Questao();
		Connection conn = null;
		Statement consulta = null;
		Object tabela = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/javalingo?verifyServerCertificate=false&useSSL=true", "root", "");
			consulta = conn.createStatement();
			String s = "pao";
			tabela = consulta.executeUpdate("UPDATE questao SET questaofeita = 0  WHERE questaofeita = 1");

			if (((ResultSet) tabela).next()) {

				questao.setQuestaofeita(((ResultSet) tabela).getString(s));

				zerarquestoes = true;
			} else {
				zerarquestoes = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
		return questao;

	}

	public QuestaoDAO() {
		super(Questao.class);
	}

}
