package com.enablee.inte.service.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FlipkartApiClient {
	RestTemplate restTemplate = new RestTemplate();
	
	public void getTopOffers() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Fk-Affiliate-Id", "gmatgamer");
		headers.set("Fk-Affiliate-Token", "7c03cb20b6194cf58b9e60147a76217c");
		
		ResponseEntity<String> response = restTemplate.exchange("https://affiliate-api.flipkart.net/affiliate/offers/v1/top/json", 
				HttpMethod.GET, new HttpEntity<byte[]>(headers), String.class);
		
		System.out.println(response.getBody());		
	}
}
