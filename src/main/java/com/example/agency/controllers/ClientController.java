package com.example.agency.controllers;



import com.example.agency.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/clients")
    public String clients(@RequestParam(name="name", required = false) String name, Model model) {
        model.addAttribute("clients", clientService.listClients(name));
        return "listOfClients";
    }

    @GetMapping("/clients/getAll")
    public String getAll(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "listOfClients";
    }
}
