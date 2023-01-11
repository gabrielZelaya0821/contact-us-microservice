package com.baas.controller;

import com.baas.model.Client;
import com.baas.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired 
	private ClientService clientService;
	
	@GetMapping("/id/{id}")
	public Client getById(@PathVariable("id") String clientId) {
		return clientService.getById(clientId);
	}
	
	@PostMapping("/save")
	public Client saveClient(@RequestBody Client client) {
		return clientService.saveClient(client);
	}
	
	@PutMapping("/update")
	public Client updateClient(@RequestBody Client client) {
		return clientService.saveClient(client);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteClient(@PathVariable("id") String clientId) {
		clientService.deleteById(clientId);
		return "ID:" + clientId + " deleted";
	}
}