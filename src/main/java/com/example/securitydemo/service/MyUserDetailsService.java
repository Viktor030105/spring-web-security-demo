package com.example.securitydemo.service;

import com.example.securitydemo.modal.UserPrincipal;
import com.example.securitydemo.modal.Users;
import com.example.securitydemo.repo.MyUserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private  MyUserDetailsRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

        if (user != null) {
            System.out.println("User is not found");
            throw new UsernameNotFoundException("User is not found");
        }
        return new UserPrincipal(user);
    }
}
