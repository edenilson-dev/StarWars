package com.el.starwars.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.el.starwars.domain.Planet;

@RestController
@RequestMapping(value="/planets")
public class PlanetResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Planet>> findAll(){
		 Planet marte = new Planet("1", "Marte", "quente", "Plaino");
		 Planet jupeter = new Planet("2", "Júpeter", "médio", "Acidentado");
		 List<Planet> planets = new ArrayList<>();
		 planets.addAll(Arrays.asList(marte, jupeter));
		 return ResponseEntity.ok().body(planets);	 
	}
	
}
