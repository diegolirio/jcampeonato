package com.diegolirio.jcampeonato.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.diegolirio.jcampeonato.builder.CampeonatoBuilder;
import com.diegolirio.jcampeonato.model.Campeonato;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class CampeonatoServiceTest {
	
	@Autowired
	private CampeonatoService campeonatoService;

	private CampeonatoBuilder builder;

	private Campeonato campeonato;
	
	@Before
	public void before() {
		builder = new CampeonatoBuilder();
		campeonato = builder.withDescricao("Champions League").build();
	}
	
	@Test
	public void testDeveSalvarCampeonato() {
		campeonatoService.save(campeonato);
		Assert.assertTrue("Deve ter gravado no banco, conter ID (ID > ZERO)", campeonato.getId() > 0);
	}
	
}
