package com.diegolirio.jcampeonato.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String base() {
		logger.info("Page Base....");
		return "_base2";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		logger.info("Page Home....");
		return "home";
	}
	
		
	
}
