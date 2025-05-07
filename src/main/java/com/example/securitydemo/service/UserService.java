package com.example.securitydemo.service;

import com.example.securitydemo.modal.Users;
import com.example.securitydemo.repo.MyUserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private MyUserDetailsRepo myUserDetailsRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return myUserDetailsRepo.save(user);
    }
}
