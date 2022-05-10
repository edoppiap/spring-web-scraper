package com.pietropaolo.scraper.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pietropaolo.scraper.model.pojo.Tour;
import com.pietropaolo.scraper.repository.ConcertoRepository;
import com.pietropaolo.scraper.repository.TourRepository;

@Service
public class FillerDatabase {
	
	@Autowired
	TourRepository tourRep;
	
	@Autowired
	ConcertoRepository concertoRep;
	
	public boolean fill(Stream<Tour> tours) {
		/*boolean result = false;
		for(Tour t : tours.toList()) {
			result = concertoRep.saveAll(t.getDate()).size() != 0;
		}*/
		return tourRep.saveAll(tours.toList()).size() != 0;
	}

}
