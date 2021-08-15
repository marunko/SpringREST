package com.restmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.restmvc.model.Client;

@Service
public class ClientServiceImpl implements ClientService{
 
	private static int lastId = 0;
	private static final List<Client> CLIENTS = new ArrayList<>();
	
	static {
		
		for(int i = 0; i < 10; i++) {
			Client client = new Client();
			client.setId(i); client.setName("Client" + i); 
			client.setAge(rend_age());
			CLIENTS.add(client);
			 
			lastId = i;
		}
		 
	}
	private static int rend_age() {
		int min = 18;
		int max = 80;
		int diff = max - min;
		Random random = new Random();
		int i = random.nextInt(diff + 1);
		i += min;
		return i;
	}
	public void create(Client client) {
		// TODO Auto-generated method stub
		client.setId(++lastId);
		CLIENTS.add(client);
	}

	public List<Client> get_all() {
		
		return CLIENTS;
	}

	public Client get_user(int id) {			
		Optional<Client> opt = Optional.ofNullable(CLIENTS.stream().filter(s->s.getId() == id).findFirst().orElse(null));
		Client client = opt.get();
		return client;
	}

	public boolean remove(int id) {
		Client opt = CLIENTS.stream().filter(s->s.getId()==id).findFirst().orElse(null);
		CLIENTS.remove(opt);
		return opt!=null? true: false;
	}

	public boolean edit(int id, Client newClient) {
		Client client = CLIENTS.stream().filter(s->s.getId()==id).findAny().orElseGet(null);
		if(client == null) return false;
		else {
			int indexInList = CLIENTS.indexOf(client);
			CLIENTS.set(indexInList,  newClient);
			return true;
		}
		 
	}
	
	
}
