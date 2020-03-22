package com.el.starwars.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.el.starwars.apis.swapi.SWAPIRestTeamplate;
import com.el.starwars.domain.Planet;
import com.el.starwars.domain.PlanetApiSW;
import com.el.starwars.domain.dto.PlanetDTO;
import com.el.starwars.services.PlanetService;

@RestController
@RequestMapping(value="/planets")
public class PlanetResource {

	@Autowired
	private PlanetService planetService;
	
	@Autowired
	private SWAPIRestTeamplate swapi;
	
	private List<PlanetApiSW> resultado = new ArrayList<PlanetApiSW>();
	
	private Calendar horaInicial = Calendar.getInstance(); 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PlanetDTO>> findAll(){
		 //List<Planet> planets = planetService.findAll(); 
		 return ResponseEntity.ok().body(insereAparicao(planetService.findAll()));	 
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<PlanetDTO> findById(@PathVariable String id){
		Planet planet = planetService.findById(id);
		return ResponseEntity.ok().body(new PlanetDTO(planet, 0));	 
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
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody PlanetDTO planetdto, @PathVariable String id){
		Planet planet = planetService.fromDTO(planetdto);
		planet.setId(id);
		planet = planetService.update(planet);
		return ResponseEntity.noContent().build();
	}
	
	public List<PlanetDTO> insereAparicao(List<Planet> planets) {
		List<PlanetDTO> resposta = new ArrayList<>();
		this.resultado =  implementsCache(this.resultado, horaInicial);
		for(Planet xPlanet: planets ) {
		
			resposta.add(new PlanetDTO(xPlanet,encontraAparicao(resultado,xPlanet)));
		}
		return resposta;
	}
	private int encontraAparicao(List<PlanetApiSW> result,Planet planet) {
		for(PlanetApiSW y: result ) {
			if(planet.getNome().equals(y.getName())) {
				return y.getFilms().size();
			}
		}	
		return 0;
	}
	 
	private List<PlanetApiSW> implementsCache(List<PlanetApiSW> result, Calendar horaInicial) {
		Calendar atual = Calendar.getInstance(); 
		Calendar horaComparar = (Calendar) horaInicial.clone();
		horaComparar.add(Calendar.HOUR_OF_DAY, 1);
		if(result.isEmpty()) {
			result = swapi.RetornaAparicoes().getBody().getResults();
		}
		if(atual.after(horaComparar)) {
			result = swapi.RetornaAparicoes().getBody().getResults(); 
			horaInicial = Calendar.getInstance(); 
		}
		return result;
	}
	
}
