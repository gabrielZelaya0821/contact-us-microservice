package com.baas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.baas.model.Client;

public interface ClientRepository extends JpaRepository<Client, String>{
	Client findByClientId(String clientId);
}