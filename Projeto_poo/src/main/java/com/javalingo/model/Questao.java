package com.javalingo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Questao {

	@Id
	@GeneratedValue
	private Long idQuestao;

	@Column(nullable = false, length = 200)
	private String questao;

	@Column(nullable = false, length = 100)
	private String resposta;

	@Column(nullable = false, length = 100)
	private String dificuldade;

	@Column(nullable = false, length = 100)
	private String altA;

	@Column(nullable = false, length = 100)
	private String altB;

	@Column(nullable = false, length = 100)
	private String altC;

	@Column(nullable = false, length = 100)
	private String altD;

	@Column(nullable = false, length = 100)
	private String questaofeita;

	public String getQuestaofeita() {
		return questaofeita;
	}

	public String setQuestaofeita(String questaofeita) {
		return this.questaofeita = questaofeita;
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}

	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getQuestao() {
		return questao;
	}

	public void setQuestao(String questao) {
		this.questao = questao;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getAltA() {
		return altA;
	}

	public String getAltB() {
		return altB;
	}

	public String getAltC() {
		return altC;
	}

	public String getAltD() {
		return altD;
	}

	public void setAltA(String altA) {
		this.altA = altA;
	}

	public void setAltB(String altB) {
		this.altB = altB;
	}

	public void setAltC(String altC) {
		this.altC = altC;
	}

	public void setAltD(String altD) {
		this.altD = altD;
	}

}
