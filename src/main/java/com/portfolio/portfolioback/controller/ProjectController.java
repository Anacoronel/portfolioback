package com.portfolio.portfolioback.controller;


import com.portfolio.portfolioback.entity.Project;
import com.portfolio.portfolioback.service.iProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/project")


public class ProjectController {
   
    @Autowired

    private iProjectService projectserv;



    
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


 