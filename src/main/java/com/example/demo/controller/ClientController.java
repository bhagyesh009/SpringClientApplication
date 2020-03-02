package com.example.demo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.SpringService;

@RestController
@RequestMapping("/apis/user")
public class ClientController {

	SpringService springService = null;

	@GetMapping("/getUser")
	public String getUser(@RequestParam("id") Integer id) {
		springService = new SpringService();
		return springService.getUserService(id);
	}

	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam("id") Integer id) {

		springService = new SpringService();
		return springService.deleteUserService(id);
	}

	@PostMapping("/insertUser")
	public String insertUser(@RequestBody String data) {
		final String uri = "http://localhost:8087/user/user";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(data, headers);
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
		return result.getBody();
	}

	@PutMapping("/updateUser")
	public String updatetUser(@RequestParam("id") Integer id, @RequestBody String data) {
		final String uri = "http://localhost:8087/user/user?id=" + id;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(data, headers);
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.PUT, entity, String.class);
		return result.getBody();
	}

}
