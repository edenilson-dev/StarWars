package com.el.starwars.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.el.starwars.domain.Planet;
import com.el.starwars.repository.PlanetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PlanetServiceTest {

	@MockBean
	private PlanetRepository planetRepository;

	@Autowired
	private PlanetService planetService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final String NOME = "OUTRO";

	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.planetRepository.insert(Mockito.any(Planet.class))).willReturn(new Planet());
		BDDMockito.given(this.planetRepository.findByNome(Mockito.anyString())).willReturn(new Planet());
	}

	@Test
	public void testPersistir() {
		Planet planet = new Planet(null, NOME, "frio", "Terreno");
		planet = this.planetService.insert(planet);

		assertNotNull(planet);

	}

	@Test
	public void testBuscarEmpresaPorNome() throws Exception {
		Planet planet = this.planetService.buscarPorNome(NOME);

		assertEquals(planet.getNome(), NOME);
	}
}
