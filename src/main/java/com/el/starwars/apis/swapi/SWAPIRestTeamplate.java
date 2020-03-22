package com.el.starwars.apis.swapi;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.el.starwars.domain.PlanetsApiSW;
import com.el.starwars.services.exception.ObjectNotFoundException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@NoArgsConstructor
@AllArgsConstructor
public class SWAPIRestTeamplate {
	
    final static String url = "https://swapi.co/api/planets/";
	   
    RestTemplate restTemplate = new RestTemplate();

	public ResponseEntity<PlanetsApiSW> RetornaAparicoes() {
		try { 
			return restTemplate.exchange(url, HttpMethod.GET,geraHeader(),PlanetsApiSW.class);
   		}catch(Exception e) {
   			throw new ObjectNotFoundException("SWAPI fora do ar");
   		}
   	}
	
	public HttpEntity<String> geraHeader(){
		
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		return entity;
	}


}
	    	