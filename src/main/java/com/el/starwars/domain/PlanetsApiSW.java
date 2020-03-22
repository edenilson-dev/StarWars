package com.el.starwars.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetsApiSW {

	private List<PlanetApiSW> results;
	
	public PlanetsApiSW(List<PlanetApiSW> results, String nome) {
		this.results = results;
	}

	public List<PlanetApiSW> getResults() {
		return results;
	}

	public void setResults(List<PlanetApiSW> results) {
		this.results = results;
	}
	
	
}
