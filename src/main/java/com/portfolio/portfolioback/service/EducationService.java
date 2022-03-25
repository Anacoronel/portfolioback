package com.portfolio.portfolioback.service;

import java.util.List;


import com.portfolio.portfolioback.entity.Education;
import com.portfolio.portfolioback.repository.EducationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class EducationService implements iEducationService {

    @Autowired
    EducationRepository educationRepository;
    @Override
    public List<Education> list(){
        return educationRepository.findAll();
    }
    @Override
    public Education getOne(int id){
        return educationRepository.findById(id).orElse(null);
    }
    
    @Override
    public void  save(Education education){
        educationRepository.save(education);
    }
    @Override
    public void delete(int id){
        educationRepository.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return educationRepository.existsById(id);
    }
    public List<Education> listByUserId(int id) {
        return educationRepository.findByUserId(id);
    }
   
}