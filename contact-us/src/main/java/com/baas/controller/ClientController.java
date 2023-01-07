package com.baas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baas.model.Client;
import com.baas.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired ClientService clientService;
	
	@GetMapping("/id")
	public Optional<Client> getById(@RequestParam(value = "clientId", defaultValue = "") String clientId) {
		return clientService.getById(clientId);
	}
	
	@GetMapping("/name")
	public Client getByName(@RequestParam(value= "name",defaultValue = "")String name) {
		return clientService.getByName(name);
	}
	
	@GetMapping("/phone")
	public Client getByPhoneNum(@RequestParam(value = "phoneNum", defaultValue = "") int phoneNum) {
		return clientService.getByPhoneNum(phoneNum);
	}
	
	@GetMapping("/address")
	public Client getByAddress(@RequestParam(value = "address", defaultValue = "") String address) {
		return clientService.getByAddress(address);
	}
	
	@GetMapping("/company")
	public Client getByCompany(@RequestParam(value = "company", defaultValue = "") String company) {
		return clientService.getByCompany(company);
	}
	
	@GetMapping("/email")
	public Client getByEmail(@RequestParam(value = "email", defaultValue = "") String email) {
		return clientService.getByEmail(email);
	}
	
	@PostMapping("/save")
	public boolean saveClient(@RequestBody(required = true) Client client) {
		return clientService.save(client);
	}
}
