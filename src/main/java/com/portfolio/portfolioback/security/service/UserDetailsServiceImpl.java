package com.portfolio.portfolioback.security.service;


import com.portfolio.portfolioback.security.entity.User;
import com.portfolio.portfolioback.security.entity.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userService.getByUsernameOrEmail(usernameOrEmail).get();
        return UserPrincipal.build(user);
    }
}