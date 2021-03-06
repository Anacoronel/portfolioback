package com.portfolio.portfolioback.service;

import java.util.List;

import com.portfolio.portfolioback.entity.Project;
import com.portfolio.portfolioback.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectService implements iProjectService {
    

    @Autowired
    ProjectRepository projectRepository;
    @Override
    public List<Project> list(){
        return projectRepository.findAll();
    }
    @Override
    public Project getOne(int id){
        return projectRepository.findById(id).orElse(null);
    }
    
    @Override
    public void  save(Project project){
        projectRepository.save(project);
    }
    @Override
    public void delete(int id){
        projectRepository.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return projectRepository.existsById(id);
    }
    public List<Project> listByUserId(int id) {
        return projectRepository.findByUserId(id);
    }
   
}