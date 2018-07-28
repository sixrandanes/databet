package com.databet.ref.competitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Service
public class CompetionService {
	
	final String competitionResource = "https://api.football-data.org/v2/competitions";
	
	private static Logger LOGGER = LoggerFactory.getLogger(CompetionService.class);
	
	private CompetitionRepository competitionRepository;
	
	
	public CompetionService(CompetitionRepository competitionRepository) {
		this.competitionRepository = competitionRepository;
	}
	
	public void searchCompetitions() {
		LOGGER.info("calling competitions...");
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Auth-Token", "a2183644de904dc0b5586bca0f40b749");
		
		HttpEntity entity = new HttpEntity(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CompetitionList> response = restTemplate.exchange(competitionResource, HttpMethod.GET, entity, CompetitionList.class);
		
		Assert.isTrue(response.getBody().getCount() == response.getBody().getCompetitions().size(), "Incoherence dans la liste des competitions reçues.");
		
		LOGGER.info("competitions repertories : {}", response.getBody().getCount());
		
		competitionRepository.saveAll(response.getBody().getCompetitions());
	}

}