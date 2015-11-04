package com.diegolirio.jcampeonato.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Jogador extends Model {

	@Id @GeneratedValue
	private long id;
	
	@NotNull @Size(min=2, max=40)
	private String nome;

	private String apelido;
	
	@JsonBackReference
	@ManyToMany(mappedBy="jogadores")
	@OrderBy(value="nome")
	private List<Time> times;
	
	@NotNull
	@ManyToOne
	private Posicao posicao;
	
	@ManyToOne
	private Campeonato campeonato;
	
	private String uriFoto = "/jcampeonato/static/core/img/jogador_no_photo.png";

	public Jogador() {}

	public Jogador(long id) {
		this.id = id;
	}
	
	public Jogador(long id, String nome) {
		this(id);
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
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

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	
	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public String getUriFoto() {
		return uriFoto;
	}

	public void setUriFoto(String uriFoto) {
		this.uriFoto = uriFoto;
	}

	@Override
	public boolean equals(Object obj) {
		return ((Jogador) obj).getId() == this.id;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", nome=" + nome
				+ ", posicao=" + posicao + "]";
	}
	
	
	
}
