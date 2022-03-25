package com.portfolio.portfolioback.service;

import java.util.List;

import com.portfolio.portfolioback.entity.Experience;

public interface iExperienceService {
    public List<Experience> list();
    public Experience getOne(int id);
    public void  save(Experience exoerience);
    public void delete(int id);
    public boolean existsById(int id);
    public List<Experience> listByUserId(int id);
}
