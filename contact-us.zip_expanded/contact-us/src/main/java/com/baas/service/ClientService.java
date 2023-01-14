package com.baas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baas.ThrowException.ClientNotFoundException;
import com.baas.model.Client;
import com.baas.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired 
	private ClientRepository clientRepository;
	
	public Client getById(String clientId) throws ClientNotFoundException {
		Client client = clientRepository.findByClientId(clientId);
		if (client != null) {
			return client;
		} else {
			throw new ClientNotFoundException("ID: "+clientId+ " couldn't be found");
		}
	}
	
	public Client saveClient(Client client) {
		Client.perepareToPersist(client);
		return clientRepository.save(client);
	}

	public void deleteById(String clientId) {
		clientRepository.deleteById(clientId);
		
	}
}
