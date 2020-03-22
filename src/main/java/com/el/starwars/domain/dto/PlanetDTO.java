package com.el.starwars.domain.dto;

import java.io.Serializable;

import com.el.starwars.domain.Planet;

public class PlanetDTO implements Serializable {

	/**
	 * Edenilson Mendonça
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private int aparicoes;
	
	public PlanetDTO() {
	}
	
	public PlanetDTO(Planet obj, int aparicoes) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.clima = obj.getClima();
		this.terreno = obj.getTerreno();
		this.aparicoes = aparicoes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	public int getAparicoes() {
		return aparicoes;
	}
	
	public void setAparicoes(int aparicoes) {
		this.aparicoes = aparicoes;
	}
	
}


