package com.pietropaolo.scraper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pietropaolo.scraper.model.pojo.Concerto;

public interface ConcertoRepository extends JpaRepository<Concerto, Long>{
	List<Concerto> findAll();
}
