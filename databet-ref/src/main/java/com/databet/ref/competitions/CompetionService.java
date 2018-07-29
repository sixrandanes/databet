package com.databet.ref.competitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.databet.ref.conf.DatabetRestTemplate;

@Service
public class CompetionService {

	final String competitionResource = "https://api.football-data.org/v2/competitions";

	private static Logger LOGGER = LoggerFactory.getLogger(CompetionService.class);

	private CompetitionRepository competitionRepository;

	private DatabetRestTemplate databetRestTemplate;

	public CompetionService(CompetitionRepository competitionRepository, DatabetRestTemplate databetRestTemplate) {
		this.competitionRepository = competitionRepository;
		this.databetRestTemplate = databetRestTemplate;
	}

	public void searchCompetitions() {
		LOGGER.info("calling competitions...");

		ResponseEntity<CompetitionList> response = this.databetRestTemplate.exchange(competitionResource, HttpMethod.GET, databetRestTemplate.configureHeaders(),
				CompetitionList.class);

		Assert.isTrue(response.getBody().getCount() == response.getBody().getCompetitions().size(), "Incoherence dans la liste des competitions reçues.");

		LOGGER.info("competitions repertories : {}", response.getBody().getCount());

		this.competitionRepository.saveAll(response.getBody().getCompetitions());
	}

}