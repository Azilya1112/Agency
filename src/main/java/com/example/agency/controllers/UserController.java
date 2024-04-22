package com.example.agency.controllers;

import com.example.agency.models.User;

import com.example.agency.repository.UserRepository;
import com.example.agency.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;
    @GetMapping("/index")
    public String home(String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
    @GetMapping("/director")
    public String director(String name, Model model) {
        model.addAttribute("name", name);
        return "user";
    }
    @GetMapping("/manager")
    public String manager(String name, Model model) {
        model.addAttribute("name", name);
        return "manager";
    }

    @GetMapping("/dashboard-director")
    public String dashboardDirector(String name, Model model) {
        model.addAttribute("name", name);
        return "dashboard-director";
    }

    @GetMapping("/dashboard-manager")
    public String dashboardManager(String name, Model model) {
        model.addAttribute("name", name);
        return "dashboard-manager";
    }

    @GetMapping("/register")
    public String register(String name, Model model) {
        model.addAttribute("name", name);
        return "registration";
    }

    @GetMapping("/authenticate")
    public String authenticate(String name, Model model) {
        model.addAttribute("name", name);
        return "authorization";
    }


    @PostMapping("/register/create")
    public String registerUser(User user) {
        userService.registerUser(user);
        return "redirect:/application";

    }

    @PostMapping("/authenticate")
    public String login(String email, String password, String role,
                        RedirectAttributes redirectAttributes) {
        if (userService.authenticate(email, password)) {
            // Проверка роли пользователя и перенаправление на соответствующую страницу
            User user = userRepository.findByEmail(email);
            if (user.getRole().equals("DIRECTOR")) {
                return "redirect:/director";
            } else if (user.getRole().equals("MANAGER")) {
                return "redirect:/manager";
            } else if (user.getRole().equals("CLIENT")) {
                return "redirect:/client";
            }
        }

        redirectAttributes.addFlashAttribute("error", "Неверное имя пользователя или пароль.");
        return "redirect:/authenticate";
    }

}
