package com.example.SmartAcademy.Controllers;

import com.example.SmartAcademy.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @RequestMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }


    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        logger.info("Attempting to register user: {}", username);
        try {
            userService.registerNewUser(username, password);
            model.addAttribute("success", "User registered successfully!");
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            logger.error("Error registering user: {}", e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "register";
        } catch (Exception e) {
            logger.error("Unexpected error: {}", e.getMessage(), e);
            model.addAttribute("error", "Internal server error. Please try again later.");
            return "register";
        }
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";  // Страница, которая будет отображаться после успешного логина
    }
}
