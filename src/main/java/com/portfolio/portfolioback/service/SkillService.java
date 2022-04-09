package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Skill;
import com.portfolio.portfolioback.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SkillService implements iSkillService{

    @Autowired
    SkillRepository skillRepository;
    @Override
    public List<Skill> list(){
        return skillRepository.findAll();
    }
    @Override
    public Skill getOne(int id){
        return (Skill) skillRepository.findByUserId(id);
    }
    
    @Override
    public void  save(Skill skill){
        skillRepository.save(skill);
    }
    @Override
    public void delete(int id){
        skillRepository.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return skillRepository.existsById(id);
    }
    public List<Skill> listByUserId(int id) {
        return skillRepository.findByUserId(id);
    }
   
}