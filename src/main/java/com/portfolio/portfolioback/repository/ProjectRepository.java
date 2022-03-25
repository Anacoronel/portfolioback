package com.portfolio.portfolioback.repository;


import java.util.List;

import com.portfolio.portfolioback.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectRepository extends JpaRepository<Project, Integer> {
        List<Project> findByUserId(int Userid);
    
    
    
}
