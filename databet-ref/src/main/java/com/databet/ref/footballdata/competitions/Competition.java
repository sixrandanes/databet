package com.databet.ref.footballdata.competitions;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.databet.ref.footballdata.areas.Area;

@Document(collection = "competitions")
public class Competition {
	
	@Id
	private int id;
	
	private Area area;
	
	private String name;
	
	private String code;
	
	private String plan;
	
	private int numberOfAvailableSeasons;
	
	private String lastUpdated;
	
	private Saison currentSeason;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public int getNumberOfAvailableSeasons() {
		return numberOfAvailableSeasons;
	}

	public void setNumberOfAvailableSeasons(int numberOfAvailableSeasons) {
		this.numberOfAvailableSeasons = numberOfAvailableSeasons;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Saison getCurrentSeason() {
		return currentSeason;
	}

	public void setCurrentSeason(Saison currentSeason) {
		this.currentSeason = currentSeason;
	}

}
