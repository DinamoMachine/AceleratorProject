package com.example.SmartAcademy.Services;

import com.example.SmartAcademy.Models.User;
import com.example.SmartAcademy.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public void registerNewUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username is already taken");
        }
        try {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(passwordEncoder.encode(password));
            newUser.setRole("ROLE_USER");
            userRepository.save(newUser);
        } catch (Exception e) {
            throw new RuntimeException("Error saving user to database: " + e.getMessage(), e);
        }
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }


    public void deleteUser(String username) {
        User user = findUserByUsername(username);
        userRepository.delete(user);
    }
}
