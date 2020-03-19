package com.el.starwars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.starwars.domain.Planet;
import com.el.starwars.repository.PlanetRepository;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository planetRepository;
	
	public List<Planet> findAll(){
		return planetRepository.findAll();
	}
}
