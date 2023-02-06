package com.baas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.baas.model.Client;

public interface ClientRepository extends JpaRepository<Client, String>{
	Optional<Client> getByEmail(String email);
}