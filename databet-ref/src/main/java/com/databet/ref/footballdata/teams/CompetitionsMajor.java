package com.databet.ref.footballdata.teams;

public enum CompetitionsMajor {
	
	LIGUE_1("Ligue 1", "France"),  //
	//LIGUE_2("Ligue 2", "France"), //
	SERIE_A("Serie A", "Italy"), //
	PREMIER_LEAGUE("Premier League", "England"), //
	BUNDESLIGA("Bundesliga", "Germany"), //
	LIGA("Primera Division", "Spain"); //
	
	CompetitionsMajor(String description, String area) {
		this.description = description;
		this.area = area;
	}
	
	private String description;
	
	private String area;

	public String getDescription() {
		return description;
	}
	
	public String getArea() {
		return area;
	}
}
