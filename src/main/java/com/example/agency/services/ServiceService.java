package com.example.agency.services;

import com.example.agency.models.Services;
import com.example.agency.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public List<Services> findAll() {
        return serviceRepository.findAll();
    }

    public List<Services> listServices(String name) {
        if (name != null) return serviceRepository.findByName(name);
        return serviceRepository.findAll();
    }

    public void saveService(Services services) {
        log.info("Saving new {}", services);
        serviceRepository.save(services);
    }

    public void deleteService(int id) {
        serviceRepository.deleteById(id);
    }

}
