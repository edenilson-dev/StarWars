package com.el.starwars.domain;

import java.io.Serializable;

public class Planet implements Serializable{
	/**
	 * Edenilson Mendonça
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String nome;
	private String clima;
	private String Terreno;
	
	public Planet() {
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
		return Terreno;
	}


	public void setTerreno(String terreno) {
		Terreno = terreno;
	}


	public Planet(String id, String nome, String clima, String terreno) {
		super();
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		Terreno = terreno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
