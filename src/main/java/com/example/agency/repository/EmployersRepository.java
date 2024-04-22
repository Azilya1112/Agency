package com.example.agency.repository;

import com.example.agency.models.Employers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployersRepository extends JpaRepository<Employers, Integer> {
    List<Employers> findByName(String name);

}
