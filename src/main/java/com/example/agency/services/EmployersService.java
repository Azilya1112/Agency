package com.example.agency.services;


import com.example.agency.models.Employers;
import com.example.agency.repository.EmployersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@Slf4j
@RequiredArgsConstructor
public class EmployersService {

    private final EmployersRepository employersRepository;


    public List<Employers> findAll() {
        return  employersRepository.findAll();
    }

    public List<Employers> listEmployers(String name) {
        if (name!=null) return employersRepository.findByName(name);
        return employersRepository.findAll();
    }

    public void saveEmployers(Employers employers) {
        log.info("Saving new {}", employers);
        employersRepository.save(employers);
    }


    public void deleteEmployers(int id) {
        employersRepository.deleteById(id);

    }

    public void updateSalary(int id, int newSalary) {
        Employers employers = employersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Сотрудник не найден"));

        employers.setSalary(newSalary);
        employersRepository.save(employers);
    }

}

