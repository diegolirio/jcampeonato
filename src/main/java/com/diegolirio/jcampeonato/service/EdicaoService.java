package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.EdicaoDao;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Status;
import com.diegolirio.jcampeonato.model.Usuario;

@Service("edicaoService")
public class EdicaoService extends AbstractGenericService<Edicao> {

	@Autowired
	private EdicaoDao edicaoDao;

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
	
	

	
	
}
