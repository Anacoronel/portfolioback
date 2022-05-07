package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Education;
import com.portfolio.portfolioback.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional

public class EducationService implements iEducationService {

    @Autowired
    EducationRepository educationRepository;
    public List<Education> list(){
        return educationRepository.findAll();
    }

    public Optional<Education> getOne(Long id){
        return educationRepository.findById(id);
    }

    public void  save(Education education){
        educationRepository.save(education);
    }

    public void delete(Long id){
        educationRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return educationRepository.existsById(id);
    }
}
