package com.example.agency.repository;

import com.example.agency.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsRepository extends JpaRepository<Clients, Integer> {

    List<Clients> findByName(String name);

}
