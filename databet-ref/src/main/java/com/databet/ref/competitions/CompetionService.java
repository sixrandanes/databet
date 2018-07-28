package com.databet.ref.competitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
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
	
	
	@Scheduled(fixedRate = 5000)
	public void searchCompetitions() {
		LOGGER.info("calling competitions...");
		
		RestTemplate restTemplate = new RestTemplate();
		CompetitionList competitions = restTemplate.getForObject(competitionResource, CompetitionList.class);
		
		Assert.isTrue(competitions.getCount() == competitions.getCompetitions().size(), "incoherence dans la liste des competitions");
		
		LOGGER.info("competitions repertories : {}", competitions.getCount());
		
		competitionRepository.saveAll(competitions.getCompetitions());
	}

}