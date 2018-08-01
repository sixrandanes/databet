package com.databet.ref.footballdata.matches;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.databet.ref.conf.DatabetRestTemplate;
import com.databet.ref.footballdata.competitions.Competition;
import com.databet.ref.footballdata.competitions.CompetitionRepository;
import com.databet.ref.footballdata.teams.CompetitionsMajor;

@Service
public class MatchService {

	final String matchResource = "https://api.football-data.org/v2/competitions/{id}/matches";

	private static Logger LOGGER = LoggerFactory.getLogger(MatchService.class);

	private MatchRepository matchRepository;

	private DatabetRestTemplate databetRestTemplate;

	private CompetitionRepository competitionRepository;

	public MatchService(MatchRepository matchesRepository, DatabetRestTemplate databetRestTemplate, CompetitionRepository competitionRepository) {
		this.matchRepository = matchesRepository;
		this.databetRestTemplate = databetRestTemplate;
		this.competitionRepository = competitionRepository;
	}

	public void searchTeams() {
		LOGGER.info("calling matchs...");

		List<String> compets = Stream.of(CompetitionsMajor.values()).map(f -> f.getDescription()).collect(Collectors.toList());

		List<Competition> competitionsMajors = competitionRepository.findByNameIn(compets);

		List<Competition> competitionsMajorsFilteredByArea = competitionsMajors.stream().filter(f -> containsName(f.getArea().getName())).collect(Collectors.toList());

		Assert.isTrue(competitionsMajorsFilteredByArea.size() == CompetitionsMajor.values().length, "Erreur dans le nombre de matchs identifiees.");

		competitionsMajorsFilteredByArea.stream().forEach(f -> findMatchesByCompetitionId(f.getId()));
	}

	public boolean containsName(final String name) {

		List<String> areasFromMajorCompet = Stream.of(CompetitionsMajor.values()).map(f -> f.getArea()).collect(Collectors.toList());

		return areasFromMajorCompet.stream().filter(o -> o.equals(name)).findFirst().isPresent();
	}

	public void findMatchesByCompetitionId(int competitionId) {
		LOGGER.info("calling matches...");

		ResponseEntity<MatchList> response = this.databetRestTemplate.exchange(matchResource, HttpMethod.GET, this.databetRestTemplate.configureHeaders(), MatchList.class,
				competitionId);

		Assert.isTrue(response.getBody().getCount() == response.getBody().getMatches().size(), "Incoherence dans la liste des matches reçues.");

		LOGGER.info("matches repertories : {}", response.getBody().getCount());

		matchRepository.saveAll(response.getBody().getMatches());
	}

}