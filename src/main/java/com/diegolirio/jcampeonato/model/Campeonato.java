package com.diegolirio.jcampeonato.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Campeonato extends Model {

	@Id @GeneratedValue
	private long id;
	
	private String descricao;

	public long getId() {
		return id;
	} 

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Campeonato [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	
}
