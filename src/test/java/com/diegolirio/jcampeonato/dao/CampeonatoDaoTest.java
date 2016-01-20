package com.diegolirio.jcampeonato.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.diegolirio.jcampeonato.model.Campeonato;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class CampeonatoDaoTest {
	
	@Autowired
	private CampeonatoDao campeonatoDao; 
	
	@Test
	public void test(){
		Assert.assertNotNull("O objeto campeonatoDao deve estar criado (Não nulo)", campeonatoDao);
	}

	@Test
	public void testDeveSalvarCampeonato() {
		Campeonato campeonato = new Campeonato();
		campeonato.setDescricao("Campeonato Vila Maria");
		this.campeonatoDao.save(campeonato);
		Assert.assertTrue("O campeonato gravado deve conter um ID (Maior que Zero)", campeonato.getId() > 0);
	}

	@Test
	public void testDeveAlterarCampeonato() {
		Campeonato campeonato = new Campeonato();
		campeonato.setDescricao("Campeonato Vila Maria");
		this.campeonatoDao.save(campeonato);
		Assert.assertTrue(campeonato.getId() > 0);
		campeonato.setDescricao("Vila Maria 2016");
		this.campeonatoDao.save(campeonato);
		campeonato = this.campeonatoDao.get(Campeonato.class, campeonato.getId());
		Assert.assertEquals("A descricao deve conter Vila Maria 2016", "Vila Maria 2016", campeonato.getDescricao());
	}
	
}
