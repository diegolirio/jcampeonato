package com.diegolirio.jcampeonato.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class JogadorInfoEdicao extends Model {

	@Id @GeneratedValue
	private long id;
	
	@ManyToOne 
	private Jogador jogador;
	
	@ManyToOne
	private Edicao edicao;
	
	private int gols = 0;
	
	private int cartaoAmarelo = 0;
	
	private int cartaoVermelho = 0;
	
	private int jogos = 0;

	public JogadorInfoEdicao() {}
	
	public JogadorInfoEdicao(Jogador jogador, Edicao edicao) {
		this.jogador = jogador;
		this.edicao = edicao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Edicao getEdicao() {
		return edicao;
	}

	public void setEdicao(Edicao edicao) {
		this.edicao = edicao;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	public int getCartaoAmarelo() {
		return cartaoAmarelo;
	}

	public void setCartaoAmarelo(int cartaAmarelo) {
		this.cartaoAmarelo = cartaAmarelo;
	}

	public int getCartaoVermelho() {
		return cartaoVermelho;
	}

	public void setCartaoVermelho(int cartaoVermelho) {
		this.cartaoVermelho = cartaoVermelho;
	}
	public int getJogos() {
		return jogos;
	}

	public void setJogos(int jogos) {
		this.jogos = jogos;
	}

	@Override
	public String toString() {
		return "JogadorInfoEdicao [id=" + id + ", jogador=" + jogador
				+ ", edicao=" + edicao + ", gols=" + gols + ", cartaoAmarelo="
				+ cartaoAmarelo + ", cartaoVermelho=" + cartaoVermelho + "]";
	}
	
	
	
}
