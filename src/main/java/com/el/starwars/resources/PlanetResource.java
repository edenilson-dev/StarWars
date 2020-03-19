package com.el.starwars.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.el.starwars.domain.Planet;
import com.el.starwars.services.PlanetService;

@RestController
@RequestMapping(value="/planets")
public class PlanetResource {

	@Autowired
	private PlanetService planetService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Planet>> findAll(){
		/*
		 * Planet marte = new Planet("1", "Marte", "quente", "Plaino"); Planet jupeter =
		 * new Planet("2", "Júpeter", "médio", "Acidentado");
		 */
		/* planets.addAll(Arrays.asList(marte, jupeter)); */
		 List<Planet> planets = planetService.findAll(); 
		 return ResponseEntity.ok().body(planets);	 
	}
	
}
