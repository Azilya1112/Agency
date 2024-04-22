package com.example.agency.controllers;

import com.example.agency.models.Employers;
import com.example.agency.repository.EmployersRepository;
import com.example.agency.services.EmployersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employers")
public class EmployersController {

    private final EmployersService employersService;

    private final EmployersRepository employersRepository;

    @GetMapping("")
    public String employers(@RequestParam(name="name", required = false) String name, Model model) {
        model.addAttribute("employers", employersService.listEmployers(name));
        return "listOfEmployers";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("employers", employersService.findAll());
        return "listOfEmployers";
    }

    @GetMapping("/getAllForManager")
    public String getAllForManager(Model model) {
        model.addAttribute("employers", employersService.findAll());
        return "listOfEmployersManager";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employers", new Employers());
        return "addEmployers";
    }

    @PostMapping("/save")
    public String saveEmployers(@ModelAttribute("employers") Employers employers) {
        employersService.saveEmployers(employers);
        return "redirect:/employers/create";
    }


    @PostMapping("/delete/{id}")
    public String deleteEmployers(@PathVariable int id) {
        employersService.deleteEmployers(id);
        return "redirect:/employers/getAll";
    }

    @PostMapping("/{id}/salary")
    public String updateSalary(@PathVariable int id, @RequestParam int newSalary) {
        employersService.updateSalary(id, newSalary);
        return "redirect:/employers/getAll";
    }


}
