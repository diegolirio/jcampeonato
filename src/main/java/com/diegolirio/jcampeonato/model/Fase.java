package com.diegolirio.jcampeonato.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Fase extends Model {

	@Id @GeneratedValue
	private long id;
	
	@NotNull @Size(min=2)
	private String descricao;
	
	private char sigla; // G=grupos, P=pontosCorridos, F=final, S=semi, Q=quartas, O=oitavas
	
	@JsonIgnore
	@OneToMany(mappedBy="fase")
	private List<Grupo> grupos;
	
	public Fase(){}

	public Fase(long id) {
		this.id = id;
	}

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

	public char getSigla() {
		return sigla;
	}

	public void setSigla(char sigla) {
		this.sigla = sigla;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	
}
