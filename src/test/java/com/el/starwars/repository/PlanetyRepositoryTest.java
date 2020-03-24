package com.el.starwars.repository;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.el.starwars.domain.Planet;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PlanetyRepositoryTest {
	
	@Autowired
	private PlanetRepository planetRepository;
	
	private static final String NOME = "Júpiter";

	@Before
	public void setUp() throws Exception {
		Planet planet = new Planet();
		planet.setClima("Frio");
		planet.setNome(NOME);
		planet.setTerreno("Acidentado");
		this.planetRepository.save(planet);
	}
	
	@After
	public final void tearDown() {
		this.planetRepository.deleteAll();
	}
	
	@Test
	public void buscarPorNome() {
		Planet planet = this.planetRepository.findByNome(NOME);
		assertEquals(NOME, planet.getNome());
	}
}
