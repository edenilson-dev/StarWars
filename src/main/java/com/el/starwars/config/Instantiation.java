package com.el.starwars.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.el.starwars.domain.Planet;
import com.el.starwars.repository.PlanetRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private PlanetRepository planetRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		planetRepository.deleteAll();
		Planet jupiter = new Planet(null, "Júpiter", "a mena", "acidentado");
		Planet plutao = new Planet(null, "plutão", "frio", "remoto");
		Planet urano = new Planet(null, "Urano", "remoto", "ok");
		
		planetRepository.saveAll(Arrays.asList(jupiter, plutao, urano));
		
	}

}
