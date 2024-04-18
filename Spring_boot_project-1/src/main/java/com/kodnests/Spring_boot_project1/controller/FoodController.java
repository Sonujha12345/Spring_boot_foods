package com.kodnests.Spring_boot_project1.controller;

import com.kodnests.Spring_boot_project1.entity.User;
import com.kodnests.Spring_boot_project1.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute("user") User user, Model model) {
        String email = user.getEmail();
        boolean status = foodService.emailExists(email);
        if (!status) {
            foodService.addUser(user);
            System.out.println("User added successfully.");
            return "redirect:/login";
        } else {
            model.addAttribute("error", "User already exists with this email.");
            return "registration";
        }
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("user") User user, Model model) {
        String email = user.getEmail();
        String password = user.getPassword();
        boolean isValidUser = foodService.validateUser(email, password);
        if (isValidUser) {
            System.out.println("User logged in successfully.");
            return "redirect:/foods";
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
    }

    @GetMapping("/foods")
    public String showDashboard() {
        return "foods";
    }
}
