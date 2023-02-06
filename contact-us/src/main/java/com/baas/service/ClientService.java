package com.baas.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.baas.ThrowException.ClientNotFoundException;
import com.baas.model.Client;
import com.baas.repository.ClientRepository;

@Service
public class ClientService {
	 
	private final ClientRepository clientRepository;
	
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public Client findById(final String clientId) throws ClientNotFoundException {
		return clientRepository.findById(clientId)
				.orElseThrow(()-> 
					new ClientNotFoundException("ID: "+clientId+" couldn't be found"));
	}
	
	public List<Client> findAllClients() {
		return clientRepository.findAll();
	}
	
	public Client updateClient(final String clientId,final Client client) throws ClientNotFoundException{
		if (clientRepository.findById(clientId) == null) {
			throw new ClientNotFoundException("ID: "+clientId+" couldn't be found");
		} else {
			Client updatedClient = 
				Client.builder()
					.clientId(clientId)
					.name(client.getName())
					.address(client.getAddress())
					.phoneNum(client.getPhoneNum())
					.email(client.getEmail())
					.company(client.getCompany())
					.questions(client.getQuestions())
					.build();
			return clientRepository.save(updatedClient);
		}
	}
	
	public Client getByEmail(final String clientEmail) throws ClientNotFoundException{
		return clientRepository.getByEmail(clientEmail)
				.orElseThrow(()-> 
					new ClientNotFoundException("Email: "+clientEmail+" couldn't be found"));
	}
	
	public Client saveClient(final Client client) {
		Client.perepareToPersist(client);
		return clientRepository.save(client);
	}

	public void deleteById(final String clientId) {
		clientRepository.deleteById(clientId);;
	}
}
