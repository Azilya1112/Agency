package com.example.agency.controllers;


import com.example.agency.models.Application;
import com.example.agency.services.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ApplicationService applicationService;


    @GetMapping("/application")
    public String applications(@RequestParam(name="name", required = false) String name, Model model) {
        model.addAttribute("applications", applicationService.listApplication(name));
        return "applications";
    }

    @GetMapping("/application/{id}")
    public String applicationInfo(@PathVariable int id, Model model) {
        model.addAttribute("application", applicationService.getApplicationById(id));
        return "application-info";
    }


    @PostMapping("/application/create")
    public String createApplication(Application application) {
        applicationService.saveApplication(application);
        return "redirect:/";
    }

    @PostMapping("/application/delete/{id}")
    public String deleteApplication(@PathVariable int id) {
        applicationService.deleteApplication(id);
        return "redirect:/";
    }


//
//    @GetMapping("/home")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "home";
//    }
}