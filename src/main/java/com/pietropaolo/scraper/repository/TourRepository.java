package com.pietropaolo.scraper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pietropaolo.scraper.model.pojo.Tour;

public interface TourRepository extends JpaRepository<Tour, Long>{
	List<Tour> findAll();
	List<Tour> findByArtista(String artista);
	List<Tour> findByTitolo(String titolo);

}
