package com.diegolirio.jcampeonato.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class CampeonatoControllerTest {
	
	@InjectMocks
	private CampeonatoController controller;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		// MainFilter filter = mock(MainFilter.class);
		// HttpServletRequest request = mock(HttpServletRequest.class);
		// HttpServletResponse response = mock(HttpServletResponse.class);
		// FilterChain chain = mock(FilterChain.class);
		//
		//
		// Connection connection = new
		// TdvConnectionFactory().getConnection("192.168.9.101", "1526", "tdp",
		// "tdvadm", "aged12");
		// System.out.println( connection );
		// request.getSession().setAttribute("connection", connection);
		// request.setAttribute("usuario", "fgoes");
		// request.setAttribute("rota", "021");
		// filter.doFilter(request, response, chain);
		//
		// MockitoAnnotations.initMocks(this);
		// StandaloneMockMvcBuilder standaloneSetup =
		// MockMvcBuilders.standaloneSetup(controller);
		// standaloneSetup.addFilter(filter, "*");
		// mockMvc = standaloneSetup.build();

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		// controller.setConnection( connection );
	}
	
	@Test
	public void testDeveRetornarPaginaHomeDoCampeonato() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.view().name("_base"))
			.andExpect(MockMvcResultMatchers.model().attributeExists("content_import"))
			.andExpect(MockMvcResultMatchers.model().attribute("content_import", "edicao-list"));
	}

}
