package com.diegolirio.jcampeonato.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class JogadorEscalado extends Model {

	@Id @GeneratedValue
	private long id;
	
	@JsonIgnore
	@ManyToOne
	private Escalacao escalacao;
	
	@ManyToOne
	private Jogador jogador;
	
	@ManyToOne
	private Time time;

	@ManyToMany(fetch=FetchType.EAGER)
	private List<Evento> eventos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Escalacao getEscalacao() {
		return escalacao;
	}

	public void setEscalacao(Escalacao escalacao) {
		this.escalacao = escalacao;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public String toString() {
		return "JogadorEscalado [id=" + id + ", escalacao=" + escalacao
				+ ", jogador=" + jogador + ", time=" + time + "]";
	}
	
	
	
}
