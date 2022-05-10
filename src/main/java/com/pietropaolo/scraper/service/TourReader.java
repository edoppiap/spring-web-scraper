package com.pietropaolo.scraper.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.pietropaolo.scraper.model.pojo.Concerto;
import com.pietropaolo.scraper.model.pojo.Tour;

@Service
public class TourReader {
	
	public List<Tour> readTourFromSite(){
		String basicUrl = "https://www.ticketone.it";
		List<Tour> tours = new ArrayList<>();
		
		try {
			Document document = Jsoup.connect(basicUrl+"/events/concerti-55/").get();
			
			for(Element el : document.select("div.listing-item")) {
				Tour t = new Tour();
				t.setDate(new ArrayList<Concerto>());
				t.setTitolo(el.select("div.event-listing-city").text());
				Document paginaArtista = Jsoup.connect(basicUrl+el.select("a[href]").attr("href")).get();
				for(Element elArtista : paginaArtista.select("div.event-listing-centered-row.event-listing-link-wrapper.theme-text-color")) {
					Concerto c = new Concerto();
					try {
						c.setData(LocalDateTime.parse(elArtista.select("time.event-listing-date[datetime]").attr("datetime"), DateTimeFormatter.ISO_OFFSET_DATE_TIME));
					}catch(DateTimeParseException e) {
						System.out.print(elArtista.select("time.event-listing-date[datetime]").attr("datetime"));
						c.setData(LocalDate.parse(elArtista.select("time.event-listing-date[datetime]").attr("datetime"), DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay());	
					}
					c.setCitta(elArtista.select("li.event-listing-venue.theme-text-color").text());
					c.setLuogo(elArtista.select("li.event-listing-event.theme-text-color").text());
					c.setDisponibile(elArtista.select("a.btn.btn-primary.theme-btn.btn-sm.btn-block.visible-lg.visible-sm.visible-md").text().equals("Biglietti"));
					
					c.setTour(t);
					t.getDate().add(c);
				}				
				
				tours.add(t);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tours;
	}

}
