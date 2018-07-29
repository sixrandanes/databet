package com.databet.ref.matches;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.databet.ref.competitions.Competition;
import com.databet.ref.competitions.Saison;

@Document(collection = "matches")
public class Match {

	@Id
	private int id;

	private Competition competition;

	private Saison season;

	private String utcDate;

	private String status;

	private int minute;

	private int attendance;

	private int matchDay;

	private String stage;

	private String group;

	private String lastUpdated;

	private TeamMatch homeTeam;

	private TeamMatch awayTeam;

	private Score score;

	private List<Goal> goals;

	private List<Booking> bookings;

	private List<Substitution> substitution;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Saison getSeason() {
		return season;
	}

	public void setSeason(Saison season) {
		this.season = season;
	}

	public String getUtcDate() {
		return utcDate;
	}

	public void setUtcDate(String utcDate) {
		this.utcDate = utcDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public int getMatchDay() {
		return matchDay;
	}

	public void setMatchDay(int matchDay) {
		this.matchDay = matchDay;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public TeamMatch getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(TeamMatch homeTeam) {
		this.homeTeam = homeTeam;
	}

	public TeamMatch getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(TeamMatch awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Substitution> getSubstitution() {
		return substitution;
	}

	public void setSubstitution(List<Substitution> substitution) {
		this.substitution = substitution;
	}

}
