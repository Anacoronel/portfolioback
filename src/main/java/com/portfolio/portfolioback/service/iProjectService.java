package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Project;

import java.util.List;
import java.util.Optional;

public interface iProjectService {
    public List<Project> list();
    public Optional<Project> getOne(Long id);
    public void  save(Project project);
    public void delete(Long id);
    public boolean existsById(Long id);
}
