package com.diegolirio.jcampeonato.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
//@Table(uniqueConstraints=@UniqueConstraint(columnNames={"descricao", "campeonato.id"}))
public class Edicao extends Model {
	
	@Id @GeneratedValue
	private long id;
	
	private String descricao;
	
	@JoinColumn(columnDefinition="default '1'")
	@ManyToOne
	private Status status;
	
	@ManyToOne
	private Campeonato campeonato;
	
	@JsonIgnore
	@OneToMany(mappedBy="edicao")
	private List<Grupo> grupos;
	
//	@JsonBackReference
//	@OneToMany(mappedBy="edicao")
//	private List<JogadorInfoEdicao> jogadoresInfoEdicao;

	@ManyToOne
	private TipoEdicao tipoEdicao;
	
	public Edicao() {}
	
	public Edicao(long id) {
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
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
//	public List<JogadorInfoEdicao> getJogadoresInfoEdicao() {
//		return jogadoresInfoEdicao;
//	}
//
//	public void setJogadoresInfoEdicao(List<JogadorInfoEdicao> jogadoresInfoEdicao) {
//		this.jogadoresInfoEdicao = jogadoresInfoEdicao;
//	}
	
	public TipoEdicao getTipoEdicao() {
		return tipoEdicao;
	}

	public void setTipoEdicao(TipoEdicao tipoEdicao) {
		this.tipoEdicao = tipoEdicao;
	}

	@Override
	public String toString() {
		return "Edicao [id=" + id + ", descricao=" + descricao + ", status="
				+ status + ", campeonato=" + campeonato + ", grupos=" + grupos
				+ ", tipoEdicao=" + tipoEdicao + "]";
	}

	
}