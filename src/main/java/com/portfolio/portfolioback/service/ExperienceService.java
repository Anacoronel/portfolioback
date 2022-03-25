package com.portfolio.portfolioback.service;


import java.util.List;

import com.portfolio.portfolioback.entity.Experience;
import com.portfolio.portfolioback.repository.ExperienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class ExperienceService implements iExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;
    @Override
    public List<Experience> list(){
        return experienceRepository.findAll();
    }
    @Override
    public Experience getOne(int id){
        return experienceRepository.findById(id).orElse(null);
    }
    
    @Override
    public void  save(Experience experience){
        experienceRepository.save(experience);
    }
    @Override
    public void delete(int id){
        experienceRepository.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return experienceRepository.existsById(id);
    }
    public List<Experience> listByUserId(int id) {
        return experienceRepository.findByUserId(id);
    }
   
}