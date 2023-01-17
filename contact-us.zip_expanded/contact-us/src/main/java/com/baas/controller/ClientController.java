package com.baas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baas.ThrowException.ClientNotFoundException;
import com.baas.model.Client;
import com.baas.service.ClientService;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clients")
public class ClientController {

	private ClientService clientService;

	public ClientController(ClientService clientService){
		this.clientService = clientService;
	}

	@GetMapping("/{id}")
	public Client getById(@PathVariable("id") String clientId) throws ClientNotFoundException {
		return clientService.getById(clientId);
	}

	@GetMapping
	public ResponseEntity<Client> findByEmail(@RequestParam final String clientEmail,
											  @RequestParam final String address) throws ClientNotFoundException {
		Client client = clientService.findByEmail(clientEmail);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@PostMapping
	public Client saveClient(@RequestBody @Valid Client client) {
		return clientService.saveClient(client);
	}


	@PutMapping
	public Client updateClient(@RequestBody @Valid Client client) {
		return clientService.saveClient(client);
	}
	
	@DeleteMapping("/{id}")
	public String deleteClient(@PathVariable("id") String clientId) {
		clientService.deleteById(clientId);
		return "ID:" + clientId + " deleted";
	}
}

	// Client Entity  ...--->	  <-1 Questions Entity .. clientId

	//    List<Question> clientQuestions /clients/{clientId}/questions/{questionId}
	//	   GET by ID /questions/{questionId}
	//     POST /questions
	//     DELETE /questions/{questionId}

//GET										 			//POST 			//DELETE
//  Client /clients/{clientId} 						 	||	/clients		|| /clients
//  Client /clients?clientEmail=i@a.com					||
//  List<>  /clients

