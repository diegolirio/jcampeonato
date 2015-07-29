package com.diegolirio.jcampeonato.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Time;
import com.diegolirio.jcampeonato.service.TimeService;

@Controller
@RequestMapping("/time")
public class TimeController {

	@Autowired
	private TimeService timeService;

	@RequestMapping(value="/get/list", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getList() {
		try {
			List<Time> times = this.timeService.getList(Time.class);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(times ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
