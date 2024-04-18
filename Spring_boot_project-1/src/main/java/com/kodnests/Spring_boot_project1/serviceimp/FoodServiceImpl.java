package com.kodnests.Spring_boot_project1.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnests.Spring_boot_project1.entity.User;
import com.kodnests.Spring_boot_project1.repgitory.FoodRepositiry;
import com.kodnests.Spring_boot_project1.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepositiry userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public boolean validateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
