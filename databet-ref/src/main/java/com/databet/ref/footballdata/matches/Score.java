package com.databet.ref.footballdata.matches;

public class Score {

	private String winner;

	private String duration;

	private Fulltime fullTime;

	private Halftime halfTime;

	private Extratime extraTime;

	private Penalties penalties;

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Fulltime getFullTime() {
		return fullTime;
	}

	public void setFullTime(Fulltime fulltime) {
		this.fullTime = fulltime;
	}

	public Halftime getHalfTime() {
		return halfTime;
	}

	public void setHalfTime(Halftime halftime) {
		this.halfTime = halftime;
	}

	public Extratime getExtraTime() {
		return extraTime;
	}

	public void setExtraTime(Extratime extratime) {
		this.extraTime = extratime;
	}

	public Penalties getPenalties() {
		return penalties;
	}

	public void setPenalties(Penalties penalties) {
		this.penalties = penalties;
	}

}
