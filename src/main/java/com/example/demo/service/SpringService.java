package com.example.demo.service;

import com.example.demo.client.Client;

public class SpringService {

	Client client = null;

	public String getUserService(int id) {
		client = new Client();
		return client.getClient(id);
	}

	public String deleteUserService(int id) {
		client = new Client();
		return client.deleteClient(id);

	}

}
