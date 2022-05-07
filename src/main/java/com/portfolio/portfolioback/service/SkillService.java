package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Skill;
import com.portfolio.portfolioback.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class SkillService implements iSkillService{


        @Autowired
        SkillRepository skillRepository;

        public List<Skill> list(){
            return skillRepository.findAll();
        }

        public Optional<Skill> getOne(Long id){
            return skillRepository.findById(id);
        }



        public void  save(Skill skill){
            skillRepository.save(skill);
        }

        public void delete(Long id){
            skillRepository.deleteById(id);
        }

        public boolean existsById(Long id){
            return skillRepository.existsById(id);
        }

    }
