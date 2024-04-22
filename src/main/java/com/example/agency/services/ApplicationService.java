package com.example.agency.services;


import com.example.agency.models.Application;
import com.example.agency.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public List<Application> listApplication(String name) {
        if (name!=null) return applicationRepository.findByName(name);
        return applicationRepository.findAll();
    }

    public List<Application> findAll() {
        return  applicationRepository.findAll();
    }

    public void saveApplication(Application application) {
        log.info("Saving new {}", application);
        applicationRepository.save(application);
    }

    public void deleteApplication(int id) {
        applicationRepository.deleteById(id);

    }

    public Application getApplicationById(int id) {
        return applicationRepository.findById(id).orElse(null);
    }
}
