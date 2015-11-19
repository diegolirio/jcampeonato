package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.EdicaoDao;
import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Grupo;
import com.diegolirio.jcampeonato.model.Status;
import com.diegolirio.jcampeonato.model.Usuario;

@Service("edicaoService")
public class EdicaoService extends AbstractGenericService<Edicao> {

	@Autowired
	private EdicaoDao edicaoDao;
	@Autowired
	private GrupoService grupoDao;

	public List<Edicao> getListPorStatus(Status status) {
		return this.edicaoDao.getListPorStatus(status);
	}

	@Override
	public void save(Edicao edicao) {
		if(edicao.getId() <= 0)
			edicao.setStatus(new Status(1l, "Pendente"));
		super.save(edicao);
	}

	public List<Edicao> getListByStatusAndUsuarioAdm(Status status, Usuario usuario) {
		return this.edicaoDao.getListByStatusAndUsuarioAdm(status, usuario);
	}

	public List<Edicao> getListByCampeonato(Campeonato campeonato) {
		return this.edicaoDao.getListByCampeonato(campeonato);
	}

	/**
	 * Confirma conclusao setando edicao e grupos da edicao para em andamento
	 * @param edicao
	 */
	public void confirmaConclusao(Edicao edicao) {
		Status emAndamento = new Status(2);
		edicao.setStatus(emAndamento);
		List<Grupo> grupos = this.grupoDao.getListaPorEdicao(edicao);
		for(Grupo g : grupos) {
			g.setStatus(emAndamento);
			this.grupoDao.save(g);
		}	
	}

	
	
}
