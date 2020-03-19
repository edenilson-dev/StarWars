package com.el.starwars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.el.starwars.domain.Planet;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String>{

}
