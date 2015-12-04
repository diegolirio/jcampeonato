package com.diegolirio.jcampeonato.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Podium extends Model {

	@Id @GeneratedValue
	private long id;
	
	@OneToOne
	private Edicao edicao;
	
	@OneToOne
	private Time timeCampeao;

	@OneToOne
	private Time timeViceCampeao;

	@OneToOne
	private Time timeTerceiroColocado;

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

	public Time getTimeCampeao() {
		return timeCampeao;
	}

	public void setTimeCampeao(Time timeCampeao) {
		this.timeCampeao = timeCampeao;
	}

	public Time getTimeViceCampeao() {
		return timeViceCampeao;
	}

	public void setTimeViceCampeao(Time timeViceCampeao) {
		this.timeViceCampeao = timeViceCampeao;
	}

	public Time getTimeTerceiroColocado() {
		return timeTerceiroColocado;
	}

	public void setTimeTerceiroColocado(Time timeTerceiroColocado) {
		this.timeTerceiroColocado = timeTerceiroColocado;
	}
	
	
	
}
