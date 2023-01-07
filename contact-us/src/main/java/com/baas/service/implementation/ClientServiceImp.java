package com.baas.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baas.model.Client;
import com.baas.repository.ClientRepository;
import com.baas.service.ClientService;

@Service
public class ClientServiceImp implements ClientService{

	@Autowired ClientRepository clientRepository;
	
	@Override
	public Optional<Client> getById(String clientId) {
		Optional<Client> client = clientRepository.findById(clientId);
		return client;
	}
	
	@Override
	public Client getByName(String name) {
		Client client = clientRepository.findByName(name);
		return client;
	}

	@Override
	public Client getByPhoneNum(int phoneNum) {
		Client client = clientRepository.findByPhone(phoneNum);
		return client;
	}

	@Override
	public Client getByCompany(String company) {
		Client client = clientRepository.findByCompany(company);
		return client;
	}

	@Override
	public Client getByEmail(String email) {
		Client client = clientRepository.findByEmail(email);
		return client;
	}

	@Override
	public Client getByAddress(String address) {
		Client client = clientRepository.findByAddress(address);
		return client;
	}
	
	@Override
	public boolean save(Client client) {
		clientRepository.save(client);
		return true;
	}
	
}
