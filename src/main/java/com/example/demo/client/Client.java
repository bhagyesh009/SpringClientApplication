package com.example.demo.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Client {
	RestTemplate restTemplate = null;
	HttpHeaders headers =null;
	
	public String getClient(int id) {
		restTemplate= new RestTemplate();
		headers = new HttpHeaders();
		final String uri = "http://localhost:8087/user/user?id=" + id;
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		return result.getBody();
	}
	
	public String deleteClient(int id) {
		final String uri = "http://localhost:8087/user/user?id=" + id;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, entity, String.class);
		return result.getBody();
	}

}
