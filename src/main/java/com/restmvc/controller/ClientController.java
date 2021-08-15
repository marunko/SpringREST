package com.restmvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restmvc.model.Client;
import com.restmvc.service.ClientService;
import com.restmvc.service.ClientServiceImpl;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	private final ClientService clientService = new ClientServiceImpl();
	
	@GetMapping("/all")
	public ResponseEntity<List<Client>> getall(){
		final List<Client> clients= clientService.get_all();
		return clients!=null &&  !clients.isEmpty()
				? new ResponseEntity<>(clients, HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Client client){
		clientService.create(client);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> take_a_user(@PathVariable int id){
		Client client = clientService.get_user(id);
		return client != null ?new ResponseEntity<>(client, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value="/edit/{id}")
	public ResponseEntity<?> edit(@PathVariable int id, @RequestBody Client client){
		
		boolean result = clientService.edit(id, client);
		return result
				? new ResponseEntity<>(client, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		
		return clientService.remove(id)
				? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	
	 
	
}
