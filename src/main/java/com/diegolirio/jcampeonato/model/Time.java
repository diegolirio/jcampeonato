package com.diegolirio.jcampeonato.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Time extends Model {

	@Id @GeneratedValue
	private long id;
	
	private String nome;
	
	@JsonBackReference
	@ManyToOne
	private Campeonato campeonato;

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

	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
