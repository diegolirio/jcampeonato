package com.diegolirio.jcampeonato.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Campeonato extends Model {

	@Id @GeneratedValue
	private long id;
	
	private String descricao;
	
	@JsonBackReference
	@ManyToMany
	private List<Time> times;

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

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "Campeonato [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	
}
