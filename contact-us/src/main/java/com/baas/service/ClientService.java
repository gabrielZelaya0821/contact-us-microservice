package com.baas.service;

import java.util.Optional;

import com.baas.model.Client;

public interface ClientService {
	Optional<Client> getById(String clientId);
	Client getByName(String name);
	Client getByPhoneNum(int phoneNum);
	Client getByCompany(String company);
	Client getByEmail(String email);
	Client getByAddress(String address);
	boolean save(Client client);
}
