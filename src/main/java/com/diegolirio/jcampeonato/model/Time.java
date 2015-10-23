package com.diegolirio.jcampeonato.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Time extends Model {

	@Id @GeneratedValue
	private long id;
	
	private String nome;
	
	@ManyToOne
	private Campeonato campeonato;
	
	@JsonBackReference
	@JsonIgnore
	@ManyToMany
	private List<Jogador> jogadores;

	public Time(){}
	
	public Time(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

//	@Override
//	public boolean equals(Object obj) {
//		return ((Time)obj).getId() == this.getId();
//	};
	
	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
