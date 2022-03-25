package com.portfolio.portfolioback.repository;


import java.util.List;

import com.portfolio.portfolioback.entity.Skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface SkillRepository extends JpaRepository<Skill, Integer> {
        List<Skill> findByUserId(int Userid);

    
}


