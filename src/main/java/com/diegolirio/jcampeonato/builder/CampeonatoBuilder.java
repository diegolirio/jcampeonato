package com.diegolirio.jcampeonato.builder;

import com.diegolirio.jcampeonato.model.Campeonato;

public class CampeonatoBuilder {
	
	private long id;
	private String descricao;
	
	public CampeonatoBuilder withId(long id) {
		this.id = id;
		return this;
	}
	
	public CampeonatoBuilder withDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}
	
	public Campeonato build() {
		Campeonato campeonato = new Campeonato();
		campeonato.setId(id);
		campeonato.setDescricao(descricao);
		return campeonato;
	}

}
