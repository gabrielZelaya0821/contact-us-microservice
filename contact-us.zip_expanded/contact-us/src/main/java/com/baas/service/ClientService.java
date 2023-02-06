package com.baas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baas.ThrowException.ClientNotFoundException;
import com.baas.model.Client;
import com.baas.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client getById(String clientId) throws ClientNotFoundException {

		return clientRepository.findById(clientId)
				.orElseThrow(() ->
						new ClientNotFoundException("ID: "+clientId+ " couldn't be found"));


	}

	public Client findByEmail(final String clientEmail) throws ClientNotFoundException {

		return clientRepository.findByEmail(clientEmail)
				.orElseThrow(() -> new ClientNotFoundException("Not found"));

	}
	
	public Client saveClient(Client client) {
		Client.perepareToPersist(client);
		return clientRepository.save(client);
	}

	public void deleteById(String clientId) {
		clientRepository.deleteById(clientId);
		
	}
}