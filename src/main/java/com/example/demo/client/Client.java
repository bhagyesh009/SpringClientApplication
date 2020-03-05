package com.example.demo.client;

import org.springframework.http.HttpEntity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.example.constants.Constant;

public class Client {

	HttpHeaders headers = new HttpHeaders();

	public Object getClient(int id) throws JsonProcessingException {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		ResponseEntity<String> result = new RestTemplate().exchange(Constant.URL + id, HttpMethod.GET, entity,
				String.class);
		return new ObjectMapper().readValue(result.getBody(), Object.class);
	}

	public Object deleteClient(int id) throws JsonMappingException, JsonProcessingException {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		ResponseEntity<String> result = new RestTemplate().exchange(Constant.URL + id, HttpMethod.DELETE, entity,
				String.class);
		return new ObjectMapper().readValue(result.getBody(), Object.class);
	}

	public Object insertClient(User user) throws JsonProcessingException {
		HttpEntity<String> entity = new HttpEntity<>(new ObjectMapper().writeValueAsString(user), headers);
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<String> result = new RestTemplate().exchange(Constant.INSERT_URL, HttpMethod.POST, entity,
				String.class);
		return new ObjectMapper().readValue(result.getBody(), Object.class);
	}

	public Object updateClient(int id, String data) throws JsonMappingException, JsonProcessingException {
		HttpEntity<String> entity = new HttpEntity<>(data, headers);
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<String> result = new RestTemplate().exchange(Constant.URL + id, HttpMethod.PUT, entity,
				String.class);
		return new ObjectMapper().readValue(result.getBody(), Object.class);
	}
}
