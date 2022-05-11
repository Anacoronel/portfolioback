package com.portfolio.portfolioback.security.controller;


import com.portfolio.portfolioback.dto.Message;
import com.portfolio.portfolioback.security.dto.JwtDto;
import com.portfolio.portfolioback.security.dto.LoginUser;
import com.portfolio.portfolioback.security.dto.NewUser;
import com.portfolio.portfolioback.security.entity.Rol;
import com.portfolio.portfolioback.security.entity.User;
import com.portfolio.portfolioback.security.enums.RolName;
import com.portfolio.portfolioback.security.jwt.JwtProvider;
import com.portfolio.portfolioback.security.service.RolService;
import com.portfolio.portfolioback.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/new")
    public ResponseEntity<?> create(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Message("Invalid fields."), HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByEmail(newUser.getEmail())){
            return new ResponseEntity(new Message("Email already exists."), HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByUsername(newUser.getUsername())){
            return new ResponseEntity(new Message("Username already exists."), HttpStatus.BAD_REQUEST);
        }
        User user = new User(newUser.getEmail(), newUser.getUsername(), passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRoleName(RolName.ROLE_USER).get());
        if(newUser.getRoles().contains("admin")){
            roles.add(rolService.getByRoleName(RolName.ROLE_ADMIN).get());}

        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Message("User saved."), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Message("Invalid fields."), HttpStatus.BAD_REQUEST);
        }
        if(!userService.existsByUsername(loginUser.getUsername())){
            return new ResponseEntity(new Message("Username doesn't exist."), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        JwtDto jwtDto = new JwtDto(jwt);
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}