package com.diegolirio.jcampeonato.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Grupo extends Model {

	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	private Edicao edicao;
	
	private String descricao;
	
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy="grupo")
	private List<Classificacao> classificacoes; 
	
	@NotNull
	@ManyToOne
	private Fase fase;	

	@NotNull
	@ManyToOne
	private Status status;	
	
	public Grupo() {}
	
	public Grupo(long id) {
		this.id = id;
	}

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

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
