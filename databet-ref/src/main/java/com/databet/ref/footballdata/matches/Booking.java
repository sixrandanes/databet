package com.databet.ref.footballdata.matches;

public class Booking {

	private int minute;

	private TeamMatch teamMatch;

	private Player player;

	private String card;

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public TeamMatch getTeamMatch() {
		return teamMatch;
	}

	public void setTeamMatch(TeamMatch teamMatch) {
		this.teamMatch = teamMatch;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

}
