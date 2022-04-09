package com.portfolio.portfolioback.repository;


import com.portfolio.portfolioback.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SkillRepository extends JpaRepository<Skill, Integer> {

    
}


