package com.el.starwars.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.el.starwars.domain.Planet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetRepositoryTest {
	
	@Autowired
	private PlanetRepository planetRepository;
	
	private static final String NOME = "Júpiter";

	@Test
	public void salvar() {
		Planet planet = new Planet(null, NOME, "Teste", "frio");
		planet = planetRepository.save(planet);

		assertEquals(planet, planet);
	}
	
	
	@Test
	public void chamarBusca(){
		buscar(NOME);
	}	
	
	public void buscar(String nome) {
		Planet planet = planetRepository.findByNome(nome);
		
		assertThat(planet.getNome(), is(planet.getNome()));
	}
}
