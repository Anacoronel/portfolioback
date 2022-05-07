package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Project;
import com.portfolio.portfolioback.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService implements iProjectService {
    

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> list(){
        return projectRepository.findAll();
    }

    public Optional<Project> getOne(Long id){
        return projectRepository.findById(id);
    }

    public void  save(Project project){
        projectRepository.save(project);
    }

    public void delete(Long id){
        projectRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return projectRepository.existsById(id);
    }
}