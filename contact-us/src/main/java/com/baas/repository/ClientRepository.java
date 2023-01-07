package com.baas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.baas.model.Client;

public interface ClientRepository extends JpaRepository<Client, String>{
	Optional<Client> findById(String clientId);
	Client findByName(String name);
	Client findByPhone(int phoneNum);
	Client findByCompany(String company);
	Client findByEmail(String email);
	Client findByAddress(String address);
}
