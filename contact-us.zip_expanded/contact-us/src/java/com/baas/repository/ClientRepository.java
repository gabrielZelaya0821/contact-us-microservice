package com.baas.repository;

import com.baas.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String>{
	Client getById(String clientId);
}
