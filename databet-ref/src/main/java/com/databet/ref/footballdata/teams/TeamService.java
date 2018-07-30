package com.databet.ref.footballdata.teams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.databet.ref.conf.DatabetRestTemplate;
import com.databet.ref.footballdata.competitions.Competition;
import com.databet.ref.footballdata.competitions.CompetitionRepository;

@Service
public class TeamService {

	private final String teamResource = "https://api.football-data.org/v2/competitions/{id}/teams";

	private static Logger LOGGER = LoggerFactory.getLogger(TeamService.class);

	private TeamRepository teamRepository;

	private CompetitionRepository competitionRepository;

	private DatabetRestTemplate databetRestTemplate;

	public TeamService(TeamRepository teamRepository, CompetitionRepository competitionRepository, DatabetRestTemplate databetRestTemplate) {
		this.teamRepository = teamRepository;
		this.competitionRepository = competitionRepository;
		this.databetRestTemplate = databetRestTemplate;
	}

	public void searchTeams() {
		LOGGER.info("calling teams...");

		List<String> compets = Stream.of(CompetitionsMajor.values()).map(f -> f.getDescription()).collect(Collectors.toList());

		List<Competition> competitionsMajors = competitionRepository.findByNameIn(compets);

		List<Competition> competitionsMajorsFilteredByArea = competitionsMajors.stream().filter(f -> containsName(f.getArea().getName())).collect(Collectors.toList());

		Assert.isTrue(competitionsMajorsFilteredByArea.size() == CompetitionsMajor.values().length, "Erreur dans le nombre de competitions identifiees.");

		competitionsMajorsFilteredByArea.stream().forEach(f -> findTeamByCompetitionId(f.getId()));
	}

	public boolean containsName(final String name) {

		List<String> areasFromMajorCompet = Stream.of(CompetitionsMajor.values()).map(f -> f.getArea()).collect(Collectors.toList());

		return areasFromMajorCompet.stream().filter(o -> o.equals(name)).findFirst().isPresent();
	}

	private void findTeamByCompetitionId(int competitionId) {

		ResponseEntity<TeamList> response = this.databetRestTemplate.exchange(teamResource, HttpMethod.GET, this.databetRestTemplate.configureHeaders(), TeamList.class,
				competitionId);

		Assert.isTrue(response.getBody().getCount() == response.getBody().getTeams().size(), "Incoherence dans la liste des teams reçues.");

		LOGGER.info("teams repertories : {}", response.getBody().getCount());

		response.getBody().getTeams().stream().forEach(f -> f.setCompetitionId(competitionId));

		teamRepository.saveAll(response.getBody().getTeams());

	}

}