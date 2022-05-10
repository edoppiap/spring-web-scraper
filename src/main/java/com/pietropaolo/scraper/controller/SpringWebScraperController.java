package com.pietropaolo.scraper.controller;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pietropaolo.scraper.model.pojo.Tour;
import com.pietropaolo.scraper.repository.TourRepository;
import com.pietropaolo.scraper.service.FillerDatabase;
import com.pietropaolo.scraper.service.TourReader;

@RestController
public class SpringWebScraperController {
	
	@Autowired
	private TourReader tourReader;
	
	@Autowired
	private TourRepository tourRepository;
	
	@Autowired
	private FillerDatabase filler;
	
	@GetMapping("/getAll")
	public ResponseEntity<Stream<Tour>> getConcerti(){
		return new ResponseEntity<>(tourRepository.findAll().parallelStream(), HttpStatus.OK);
	}
	
	@GetMapping("/fill")
	public ResponseEntity<String> fillDataBase() throws IOException{
		String result = "";
		if(filler.fill(tourReader.readTourFromSite())) {
			result = "Everything saved";
		}else {
			result = "Something gone wrong";
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
