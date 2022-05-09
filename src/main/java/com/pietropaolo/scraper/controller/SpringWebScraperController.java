package com.pietropaolo.scraper.controller;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pietropaolo.scraper.model.pojo.Concerto;
import com.pietropaolo.scraper.model.pojo.Tour;

@RestController
public class SpringWebScraperController {
	
	@GetMapping("/hello")
	public ResponseEntity<Tour> getString(){
		Tour t = new Tour("Vasco Rossi", "VASCO");
		Concerto c1 = new Concerto("Roma", "Palalottomatica", LocalDate.of(2022, 9, 15));
		Concerto c2 = new Concerto("Roma", "Ostia Antica", LocalDate.of(2022, 9, 18));
		c1.setTour(t);
		c2.setTour(t);
		t.setDate(Arrays.asList(c1, c2));
		return new ResponseEntity<>(t, HttpStatus.OK);
	}

}
