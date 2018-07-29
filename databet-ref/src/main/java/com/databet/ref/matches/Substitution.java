package com.databet.ref.matches;

public class Substitution {

	private int minute;

	private TeamMatch team;

	private Player playerOut;

	private Player payerIn;

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public TeamMatch getTeam() {
		return team;
	}

	public void setTeam(TeamMatch team) {
		this.team = team;
	}

	public Player getPlayerOut() {
		return playerOut;
	}

	public void setPlayerOut(Player playerOut) {
		this.playerOut = playerOut;
	}

	public Player getPayerIn() {
		return payerIn;
	}

	public void setPayerIn(Player payerIn) {
		this.payerIn = payerIn;
	}

}
