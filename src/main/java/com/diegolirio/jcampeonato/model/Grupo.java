package com.diegolirio.jcampeonato.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Grupo extends Model {

	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	private Edicao edicao;
	
	private String descricao;
	
	@JsonBackReference
	@OneToMany(mappedBy="grupo")
	private List<Classificacao> classificacoes; 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Edicao getEdicao() {
		return edicao;
	}

	public void setEdicao(Edicao edicao) {
		this.edicao = edicao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Classificacao> getClassificacoes() {
		return classificacoes;
	}

	public void setClassificacoes(List<Classificacao> classificacoes) {
		this.classificacoes = classificacoes;
	}
	
	
	
}
