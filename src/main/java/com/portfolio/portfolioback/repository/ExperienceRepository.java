package com.portfolio.portfolioback.repository;

import java.util.List;

import com.portfolio.portfolioback.entity.Experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    List<Experience> findByUserId(int Userid);

}