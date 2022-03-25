package com.portfolio.portfolioback.controller;


import java.util.ArrayList;
import java.util.List;

import com.portfolio.portfolioback.entity.Project;
import com.portfolio.portfolioback.service.iProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/project")


public class ProjectController {
   
    @Autowired

    private iProjectService projectserv;


    List<Project> listProjects = new ArrayList<>();
    
    
    @PostMapping("/new")
    public Project save(@RequestBody Project project){
        projectserv.save(project);
        return project;
    }
    

    public void setProjectService(iProjectService projectserv) {
        this.projectserv = projectserv;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Project> list(){
        return projectserv.list();
    }
    @GetMapping("/{id}")
	public  Project getOne(@PathVariable Integer id){
            return projectserv.getOne(id);
             
        }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        projectserv.delete(id);
    }
    @PutMapping("/edit/{id}")
    public Project edit(@PathVariable Integer id,@RequestBody Project project){
         projectserv.getOne(id);
        
        project.setDate(project.getDate());
        project.setText(project.getText());
        project.setLink(project.getLink());
        project.setTecn(project.getTecn());

        projectserv.save(project);
        return project;
    }
    
}


 