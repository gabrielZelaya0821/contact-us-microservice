package com.baas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.baas.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String>{

    Optional<Client> findByEmail(String email);



}