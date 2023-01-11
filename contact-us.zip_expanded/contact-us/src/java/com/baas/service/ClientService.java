package com.baas.service;

import com.baas.model.Client;
import com.baas.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientService {
	
	@Autowired 
	private ClientRepository clientRepository;
	
	public Client getById(String clientId) {
		return clientRepository.getById(clientId);
	}
	
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	public void deleteById(String clientId) {
		clientRepository.deleteById(clientId);
		
	}
}
