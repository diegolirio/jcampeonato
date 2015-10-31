package com.diegolirio.jcampeonato.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Evento extends Model {

	@Id @GeneratedValue
	private long id;
	
	@Column(unique=true)
	private String descricao;
	
	private String imgName;
	
	@JsonIgnore
	@ManyToMany(mappedBy="eventos")
	private List<JogadorEscalado> jogadoresEscalados;
	
	public Evento() {}
	
	public Evento(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<JogadorEscalado> getJogadoresEscalados() {
		return jogadoresEscalados;
	}

	public void setJogadoresEscalados(List<JogadorEscalado> jogadoresEscalados) {
		this.jogadoresEscalados = jogadoresEscalados;
	}

	@Override
	public boolean equals(Object obj) {
		return this.getId() == ((Evento)obj).getId();
	}
	
}
