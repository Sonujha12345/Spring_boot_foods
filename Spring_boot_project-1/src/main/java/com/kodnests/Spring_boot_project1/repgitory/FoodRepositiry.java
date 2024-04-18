package com.kodnests.Spring_boot_project1.repgitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnests.Spring_boot_project1.entity.User;
@Repository
public interface FoodRepositiry extends JpaRepository<User, String>{

	User findByEmail(String email);
}
