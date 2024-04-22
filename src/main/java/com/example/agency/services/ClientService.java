package com.example.agency.services;


import com.example.agency.models.Clients;
import com.example.agency.repository.ClientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    public final ClientsRepository clientsRepository;

    public List<Clients> findAll() {
        return  clientsRepository.findAll();
    }

    public List<Clients> listClients(String name) {
        if (name!=null) return clientsRepository.findByName(name);
        return clientsRepository.findAll();
    }

}
