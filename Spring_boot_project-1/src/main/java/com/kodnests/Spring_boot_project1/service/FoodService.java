package com.kodnests.Spring_boot_project1.service;

import com.kodnests.Spring_boot_project1.entity.User;

public interface FoodService {
    void addUser(User user);
    boolean emailExists(String email);
    boolean validateUser(String email, String password);
}

