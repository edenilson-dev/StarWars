package com.el.starwars.resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.el.starwars.domain.Planet;
import com.el.starwars.domain.dto.PlanetDTO;
import com.el.starwars.services.PlanetService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PlanetResourceTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private PlanetService planetService;
	
	private static final String URL_BASE = "/planets";
	private static final String ID_PLANETS = "ASDÇFLKAJSDF";
	private static final String NOME = "Júpiter";
	private static final String CLIMA = "Frio";
	private static final String TERRENO = "Acidentado";
	
	
	@Test
	public void testCadastrarPlanets() throws Exception {
		PlanetDTO planetDTO = new PlanetDTO();
		planetDTO = obterDadosPlanetDto();
			
		BDDMockito.given(this.planetService.insert(Mockito.any(Planet.class))).willReturn(new Planet());
		
		
		/*
		 * mvc.perform(MockMvcRequestBuilders.post(URL_BASE)
		 * .content(this.obterJsonPlanetPost()) .contentType(MediaType.APPLICATION_JSON)
		 * .accept(MediaType.APPLICATION_JSON)) .andExpect(status().isOk())
		 * .andExpect(jsonPath("$.id").value(ID_PLANETS))
		 * .andExpect(jsonPath("$.nome").value(NOME))
		 * .andExpect(jsonPath("$.clima").value(CLIMA))
		 * .andExpect(jsonPath("$.terreno").value(TERRENO));
		 */
	}

	private Planet fromPlanetDTO(PlanetDTO planetDTO) {
		Planet planet = new Planet();
		planet.setId(planetDTO.getId());
		planet.setNome(planetDTO.getNome());
		planet.setClima(planetDTO.getClima());
		planet.setTerreno(planetDTO.getTerreno());
		return planet;
	}

	private PlanetDTO obterDadosPlanetDto() {
		PlanetDTO planetDTO = new PlanetDTO();
		planetDTO.setId(ID_PLANETS);
		planetDTO.setNome(NOME);
		planetDTO.setClima(CLIMA);
		planetDTO.setTerreno(TERRENO);
		return planetDTO;
	}

	/*
	 * private String obterJsonPlanetPost() throws JsonProcessingException {
	 * PlanetDTO planetDto = new PlanetDTO();
	 * 
	 * planetDto.setNome("Júpiter"); planetDto.setClima("Frio");
	 * planetDto.setTerreno("Acidentado");
	 * 
	 * ObjectMapper mapper = new ObjectMapper(); return
	 * mapper.writeValueAsString(planetDto); }
	 */

}
