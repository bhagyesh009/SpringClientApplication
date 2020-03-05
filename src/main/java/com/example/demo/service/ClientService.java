package com.example.demo.service;


import com.example.demo.client.Client;
import com.example.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ClientService {

	 

	public Object getUserService(int id) throws JsonProcessingException {
		return new Client().getClient(id);
	}

	public Object deleteUserService(int id) throws JsonMappingException, JsonProcessingException {
		return new Client().deleteClient(id);

	}

	public Object insertUserService(User user) throws JsonMappingException, JsonProcessingException {
		
		
		user.setMobNo(Long.parseLong(("91" + Long.toString(user.getMobNo()))));
		return new Client().insertClient(user);

	}

	public Object updateUserService(int id, String data) throws JsonMappingException, JsonProcessingException {
		return new Client().updateClient(id, data);

	}

}
