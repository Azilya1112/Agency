package com.example.agency.controllers;

import com.example.agency.models.Services;
import com.example.agency.services.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/service")
public class ServiceController {
    private final ServiceService serviceService;

    @GetMapping
    public String services(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("services", serviceService.listServices(name));
        return "listOfServices";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("services", serviceService.findAll());
        return "listOfServices";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("services", new Services());
        return "addService";
    }

    @PostMapping("/save")
    public String saveEmployers(@ModelAttribute("services") Services services) {
        serviceService.saveService(services);
        return "redirect:/service/create";
    }

    @PostMapping("/delete/{id}")
    public String deleteService(@PathVariable int id) {
        serviceService.deleteService(id);
        return "redirect:/service/getAll";
    }

}
