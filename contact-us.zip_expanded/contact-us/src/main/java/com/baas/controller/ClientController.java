package com.baas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baas.ThrowException.ClientNotFoundException;
import com.baas.model.Client;
import com.baas.service.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired 
	public ClientService clientService;
	
	@GetMapping("/id/{id}")
	public Client getById(@PathVariable("id") String clientId) throws ClientNotFoundException {
		return clientService.getById(clientId);
	}
 	
	@PostMapping("/save")
	public Client saveClient(@RequestBody @Valid Client client) {
		return clientService.saveClient(client);
	}
	
	@PutMapping("/update")
	public Client updateClient(@RequestBody @Valid Client client) {
		return clientService.saveClient(client);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteClient(@PathVariable("id") String clientId) {
		clientService.deleteById(clientId);
		return "ID:" + clientId + " deleted";
	}
}