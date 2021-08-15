package com.restmvc.service;

import java.util.List;

import com.restmvc.model.Client;

public interface ClientService {
	
	void create(Client client);
	
	List<Client> get_all();
	
	Client get_user(int id);
	
	boolean remove(int id);
	
	boolean edit(int id, Client client);
}
