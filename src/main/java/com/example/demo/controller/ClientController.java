package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.service.ClientService;
import com.example.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/apis/users")
public class ClientController {

	@GetMapping("/{id}")
	public Object getUser(@PathVariable("id") int id) throws JsonProcessingException {
		return new ClientService().getUserService(id);
	}

	@DeleteMapping("/{id}")
	public Object deleteUser(@PathVariable("id") int id) throws JsonMappingException, JsonProcessingException {
		return new ClientService().deleteUserService(id);
	}

	@PostMapping("")
	public Object insertUser(@RequestBody User user) throws JsonMappingException, JsonProcessingException {
		return new ClientService().insertUserService(user);
	}

	@PutMapping("/{id}")
	public Object updatetUser(@PathVariable("id") int id, @RequestBody String data) throws JsonMappingException, JsonProcessingException {
		return new ClientService().updateUserService(id,data);
	}

}
