package com.example.agency.repository;

import com.example.agency.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Services, Integer> {
    List<Services>  findByName(String name);
}
