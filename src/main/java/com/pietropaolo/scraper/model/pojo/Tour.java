package com.pietropaolo.scraper.model.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Tour {
	
	public Tour(String artista, String titolo) {
		super();
		this.artista = artista;
		this.titolo = titolo;
	}
	
	public Tour() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String artista;
	private String titolo;
	
	@OneToMany(mappedBy = "tour")
	private List<Concerto> date;
	
	@JsonProperty("artista")
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	@JsonProperty("titolo")
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@JsonProperty("date")
	public List<Concerto> getDate() {
		return date;
	}

	public void setDate(List<Concerto> date) {
		this.date = date;
	}
}
