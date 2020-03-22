package com.el.starwars.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetApiSW implements Serializable{

	/**
	 * Edenilsom Mendonça
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private List<String> films;
	
	public PlanetApiSW(String name, List<String> films) {
		this.name = name;
		this.films = films;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}
}
