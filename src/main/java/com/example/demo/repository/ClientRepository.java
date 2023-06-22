package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Client;

public interface ClientRepository extends JpaRepository<Client, UUID>{
	
	int countByIsEnabled(boolean isEnabled);
	
	Page<Client> findByIsEnabled(boolean isEnabled, Pageable pageable);
	
}
