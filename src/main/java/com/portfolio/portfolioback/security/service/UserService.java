package com.portfolio.portfolioback.security.service;


import com.portfolio.portfolioback.security.entity.User;
import com.portfolio.portfolioback.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;


@Service
@Transactional
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    public List<User> list() {
        return userRepository.findAll();
    }
    
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    

    
    public Optional<User> getByUsernameOrEmail(String usernameOrEmail) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    }
    public Optional<User> getByTokenPassword(String tokenPassword){
        return userRepository.findByTokenPassword(tokenPassword);
    }
    
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
    
    public boolean existsByUsernameOrEmail(String usernameOrEmail) {
        return userRepository.existsByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    }    
    
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    
    public void save(User user) {
        userRepository.save(user);
    }
}