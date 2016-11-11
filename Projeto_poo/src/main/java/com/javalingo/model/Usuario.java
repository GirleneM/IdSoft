package com.javalingo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long idUsuario;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(length = 20)
	private String usuario;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 20)
	private String senha;
	
	@Column(length = 10)
	private int testesfeitos;
	
	@Column(length = 10)
	private int questaocerta;
	
	@Column(length = 10)
	private int questaoerrada;
	
	@Column(length = 10)
	private double porcetagemtotal;
	
	public int getTestesfeitos() {
		return testesfeitos;
	}
	public void setTestesfeitos(int testesfeitos) {
		this.testesfeitos = testesfeitos;
	}
	public int getQuestaocerta() {
		return questaocerta;
	}
	public void setQuestaocerta(int questaocerta) {
		this.questaocerta = questaocerta;
	}
	public int getQuestaoerrada() {
		return questaoerrada;
	}
	public void setQuestaoerrada(int questaoerrada) {
		this.questaoerrada = questaoerrada;
	}
	public double getPorcetagemtotal() {
		return porcetagemtotal;
	}
	public void setPorcetagemtotal(double porcetagemtotal) {
		this.porcetagemtotal = porcetagemtotal;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
