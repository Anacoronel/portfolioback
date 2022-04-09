package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Education;

import java.util.List;
import java.util.Optional;

public interface iEducationService {
    public List<Education> list();
    public Optional<Education> getOne(int id);
    public void  save(Education education);
    public void delete(int id);
    public boolean existsById(int id);
}
