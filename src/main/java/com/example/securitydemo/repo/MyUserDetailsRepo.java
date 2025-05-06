package com.example.securitydemo.repo;

import com.example.securitydemo.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserDetailsRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}
