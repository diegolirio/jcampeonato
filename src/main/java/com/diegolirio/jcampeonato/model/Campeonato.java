package com.diegolirio.jcampeonato.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Campeonato extends Model {

	@Id @GeneratedValue
	private long id;
	
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy="campeonato")
	private List<UsuarioPerfilCampeonato> usuariosPerfisCampeonatos;

	public Campeonato(){}
	
	public Campeonato(long id) {
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

	public List<UsuarioPerfilCampeonato> getUsuariosPerfisCampeonatos() {
		return usuariosPerfisCampeonatos;
	}

	public void setUsuariosPerfisCampeonatos(
			List<UsuarioPerfilCampeonato> usuariosPerfisCampeonatos) {
		this.usuariosPerfisCampeonatos = usuariosPerfisCampeonatos;
	}

	@Override
	public String toString() {
		return "Campeonato [id=" + id + ", descricao=" + descricao + "]";
	}
	
}
