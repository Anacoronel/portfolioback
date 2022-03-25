package com.portfolio.portfolioback.repository;

import java.util.List;

import com.portfolio.portfolioback.entity.About;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<About, Integer> {
    List<About> findByUserId(int Userid);

}
