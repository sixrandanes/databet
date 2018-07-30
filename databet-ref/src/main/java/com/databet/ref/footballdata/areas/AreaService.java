package com.databet.ref.footballdata.areas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.databet.ref.conf.DatabetRestTemplate;

@Service
public class AreaService {

	final String areaResource = "https://api.football-data.org/v2/areas";

	private static Logger LOGGER = LoggerFactory.getLogger(AreaService.class);

	private AreaRepository areaRepository;

	private DatabetRestTemplate databetRestTemplate;

	public AreaService(AreaRepository areaRepository, DatabetRestTemplate databetRestTemplate) {
		this.areaRepository = areaRepository;
		this.databetRestTemplate = databetRestTemplate;
	}

	public void searchAreas() {
		LOGGER.info("calling areas...");

		ResponseEntity<AreaList> response = this.databetRestTemplate.exchange(areaResource, HttpMethod.GET, this.databetRestTemplate.configureHeaders(), AreaList.class);

		Assert.isTrue(response.getBody().getCount() == response.getBody().getAreas().size(), "Incoherence dans la liste des areas reçues.");

		LOGGER.info("areas repertories : {}", response.getBody().getCount());

		areaRepository.saveAll(response.getBody().getAreas());
	}

}