package com.portfolio.portfolioback.repository;


import java.util.List;

import com.portfolio.portfolioback.entity.Education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
    List<Education> findByUserId(int Userid);

}