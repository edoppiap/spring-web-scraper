package com.pietropaolo.scraper.model.pojo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Concerto {
	
	public Concerto() {
		
	}
	
	public Concerto(String citta, String luogo, LocalDate data) {
		super();
		this.citta = citta;
		this.luogo = luogo;
		this.data = data;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String citta;
	private String luogo;
	private LocalDate data;
	
	@ManyToOne
	private Tour tour;
	
	@JsonProperty("citta'")
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	@JsonProperty("data")
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	@JsonProperty("luogo")
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	@JsonIgnore
	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

}
