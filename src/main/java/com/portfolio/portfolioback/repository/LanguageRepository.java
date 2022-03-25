package com.portfolio.portfolioback.repository;


import java.util.List;

import com.portfolio.portfolioback.entity.Language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    List<Language> findByUserId(int Userid);

}