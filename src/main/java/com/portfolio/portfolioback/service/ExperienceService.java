package com.portfolio.portfolioback.service;


import com.portfolio.portfolioback.entity.Experience;
import com.portfolio.portfolioback.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ExperienceService implements iExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    public List<Experience> list(){
        return experienceRepository.findAll();
    }

    public Optional<Experience> getOne(Long id){
        return experienceRepository.findById(id);
    }

    public void  save(Experience experience){
        experienceRepository.save(experience);
    }

    public void delete(Long id){
        experienceRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return experienceRepository.existsById(id);
    }
}