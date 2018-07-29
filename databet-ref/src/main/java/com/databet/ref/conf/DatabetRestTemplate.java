package com.databet.ref.conf;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class DatabetRestTemplate extends RestTemplate {

	public DatabetRestTemplate() {
	}

	public DatabetRestTemplate(ClientHttpRequestFactory requestFactory) {
		setRequestFactory(requestFactory);
	}

	public HttpEntity<String> configureHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Auth-Token", "a2183644de904dc0b5586bca0f40b749");
		return new HttpEntity<>(headers);
	}
}
