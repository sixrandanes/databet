package com.databet.ref.footballdata.areas;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "areas")
public class Area {

	@Id
	private int id;
	
	private String name;
	
	private String countryCode;
	
	private int parentAreaId;
	
	private String aparentArea;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getParentAreaId() {
		return parentAreaId;
	}

	public void setParentAreaId(int parentAreaId) {
		this.parentAreaId = parentAreaId;
	}

	public String getAparentArea() {
		return aparentArea;
	}

	public void setAparentArea(String aparentArea) {
		this.aparentArea = aparentArea;
	}

}
