package com.el.starwars.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.starwars.domain.Planet;
import com.el.starwars.domain.dto.PlanetDTO;
import com.el.starwars.repository.PlanetRepository;
import com.el.starwars.services.exception.ObjectNotFoundException;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository planetRepository;
	
	public List<Planet> findAll(){
		return planetRepository.findAll();
	}
	
	public Planet findById(String id){
		Optional<Planet> planet = planetRepository.findById(id);
		return planet.orElseThrow(()-> new ObjectNotFoundException("Planet não encontrado"));
	}
	
	public Planet insert(Planet planet) {
		return planetRepository.save(planet);
	}
	
	public void delete(String id) {
		findById(id);
		planetRepository.deleteById(id);
	}
	
	public Planet fromDTO(PlanetDTO planetdto) {
		return new Planet(planetdto.getId(), planetdto.getNome(), planetdto.getClima(), planetdto.getTerreno());
	}
}
