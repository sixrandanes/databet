package com.databet.ref;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompetionService {
	
	final String competitionResource = "https://api.football-data.org/v2/competitions";
	
	private CompetitionRepository competitionRepository;
	
	
	public CompetionService(CompetitionRepository competitionRepository) {
		this.competitionRepository = competitionRepository;
	}
	
	
	@Scheduled(fixedRate = 35000)
	public void searchCompetitions() {
		RestTemplate restTemplate = new RestTemplate();
		CompetitionList competitions = restTemplate.getForObject(competitionResource, CompetitionList.class);
		
		competitionRepository.saveAll(competitions.getCompetitions());
	}

}
