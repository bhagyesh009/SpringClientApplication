package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.service.SpringService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/apis/users")
public class ClientController {

	@GetMapping("/{id}")
	public String getUser(@PathVariable("id") int id) {
		return new SpringService().getUserService(id);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		return new SpringService().deleteUserService(id);
	}

	@PostMapping("")
	public String insertUser(@RequestBody String data) throws JsonMappingException, JsonProcessingException {
		return new SpringService().insertUserService(data);
	}

	@PutMapping("/{id}")
	public String updatetUser(@PathVariable("id") int id, @RequestBody String data) {
		return new SpringService().updateUserService(id,data);
	}

}
