package com.portfolio.portfolioback.service;

import java.util.List;

import com.portfolio.portfolioback.entity.Project;

public interface iProjectService {
    public List<Project> list();
    public Project getOne(int id);
    public void  save(Project project);
    public void delete(int id);
    public boolean existsById(int id);
    public List<Project> listByUserId(int id);
}
