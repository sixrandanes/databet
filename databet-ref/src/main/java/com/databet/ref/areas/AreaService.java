package com.databet.ref.areas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Service
public class AreaService {
	
	final String areaResource = "https://api.football-data.org/v2/areas";
	
	private static Logger LOGGER = LoggerFactory.getLogger(AreaService.class);
	
	private AreaRepository areaRepository;
	
	
	public AreaService(AreaRepository areaRepository) {
		this.areaRepository = areaRepository;
	}
	
	
	@Scheduled(fixedRate = 10000)
	public void searchAreas() {
	LOGGER.info("calling areas...");
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Auth-Token", "a2183644de904dc0b5586bca0f40b749");
		
		HttpEntity entity = new HttpEntity(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AreaList> response = restTemplate.exchange(areaResource, HttpMethod.GET, entity, AreaList.class);
		
		Assert.isTrue(response.getBody().getCount() == response.getBody().getAreas().size(), "Incoherence dans la liste des areas reçues.");
		
		LOGGER.info("areas repertories : {}", response.getBody().getCount());
		
		areaRepository.saveAll(response.getBody().getAreas());
	}

}