package com.example.demo.service;

import com.example.demo.client.Client;
import com.example.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpringService {


	User user = null;

	public String getUserService(int id) {
		return new Client().getClient(id);
	}

	public String deleteUserService(int id) {
		return new Client().deleteClient(id);

	}

	public String insertUserService(String data) throws JsonMappingException, JsonProcessingException {
		
		user = new User();
		user = new ObjectMapper().readValue(data, User.class);
		user.setMobNo(Long.parseLong(("91" + Long.toString(user.getMobNo()))));
		return new Client().insertClient(user);

	}

	public String updateUserService(int id) {
		return new Client().deleteClient(id);

	}

}
