package com.example.agency.services;

import com.example.agency.models.User;
import com.example.agency.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public void registerUser(User user) {
        log.info("Saving new {}", user);
        userRepository.save(user);
    }

    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && password.equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    public boolean hasRole(User user, String role) {
        return user.getRole().equals(role);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
