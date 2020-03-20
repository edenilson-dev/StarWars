package com.el.starwars.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.el.starwars.domain.Planet;
import com.el.starwars.domain.dto.PlanetDTO;
import com.el.starwars.services.PlanetService;

@RestController
@RequestMapping(value="/planets")
public class PlanetResource {

	@Autowired
	private PlanetService planetService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PlanetDTO>> findAll(){
		 List<Planet> planets = planetService.findAll(); 
		 List<PlanetDTO> listDTO = planets.stream().map(x -> new PlanetDTO(x)).collect(Collectors.toList());
		 return ResponseEntity.ok().body(listDTO);	 
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<PlanetDTO> findById(@PathVariable String id){
		Planet planet = planetService.findById(id);
		return ResponseEntity.ok().body(new PlanetDTO(planet));	 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PlanetDTO planetdto){
		Planet planet = planetService.fromDTO(planetdto);
		planet = planetService.insert(planet);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(planet.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		planetService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
