package com.example.demo.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.example.constants.Constant;

public class Client {
	RestTemplate restTemplate = null;
	HttpHeaders headers = null;
	ObjectMapper mapper = null;

	public String getClient(int id) {

		new HttpHeaders().setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		ResponseEntity<String> result = new RestTemplate().exchange(Constant.URL + id, HttpMethod.GET, entity,
				String.class);
		return result.getBody();
	}

	public String deleteClient(int id) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(Constant.URL + id, HttpMethod.DELETE, entity,
				String.class);
		return result.getBody();
	}

	public String insertClient(User user) throws JsonProcessingException {
		mapper = new ObjectMapper();

		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(user), headers);
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<String> result = restTemplate.exchange(Constant.INSERT_URL, HttpMethod.POST, entity, String.class);
		return result.getBody();
	}

	public String udateClient() {

		return null;
	}
}
