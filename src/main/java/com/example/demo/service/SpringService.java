package com.example.demo.service;

import com.example.demo.client.Client;
import com.example.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpringService {

	public String getUserService(int id) {
		return new Client().getClient(id);
	}

	public String deleteUserService(int id) {
		return new Client().deleteClient(id);

	}

	public String insertUserService(String data) throws JsonMappingException, JsonProcessingException {

		//User user = new User();
		//user = new ObjectMapper().readValue(data, User.class);
		new ObjectMapper().readValue(data, User.class).setMobNo(Long.parseLong(("91" + Long.toString(new ObjectMapper().readValue(data, User.class).getMobNo()))));
		return new Client().insertClient(new ObjectMapper().readValue(data, User.class));

	}

	public String updateUserService(int id, String data) {
		return new Client().updateClient(id, data);

	}

}
