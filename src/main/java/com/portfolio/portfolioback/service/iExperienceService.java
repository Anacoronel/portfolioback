package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Experience;

import java.util.List;
import java.util.Optional;

public interface iExperienceService {
    public List<Experience> list();
    public Optional<Experience> getOne(int id);
    public void  save(Experience experience);
    public void delete(int id);
    public boolean existsById(int id);
}
