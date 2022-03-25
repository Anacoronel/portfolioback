package com.portfolio.portfolioback.security.service;


import java.util.Optional;

import com.portfolio.portfolioback.security.entity.Rol;
import com.portfolio.portfolioback.security.enums.RolName;
import com.portfolio.portfolioback.security.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol> getByRolName(RolName rolName) {
        return rolRepository.findByRolName(rolName);
    }
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}