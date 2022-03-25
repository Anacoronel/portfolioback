package com.portfolio.portfolioback.controller;


import java.util.ArrayList;
import java.util.List;

import com.portfolio.portfolioback.entity.Education;
import com.portfolio.portfolioback.service.iEducationService;

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
@RequestMapping("/education")


public class EducationController {
   
    @Autowired

    private iEducationService educationserv;


    List<Education> listEducations = new ArrayList<>();
    
    
    @PostMapping("/new")
    public Education save(@RequestBody Education education){
        educationserv.save(education);
        return education;
    }
    

    public void setEducationService(iEducationService educationserv) {
        this.educationserv = educationserv;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Education> list(){
        return educationserv.list();
    }
    @GetMapping("/{id}")
	public  Education getOne(@PathVariable Integer id){
            return educationserv.getOne(id);
             
        }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        educationserv.delete(id);
    }
    @PutMapping("/edit/{id}")
    public Education edit(@PathVariable Integer id,@RequestBody Education education){
         educationserv.getOne(id);
        
        education.setDate(education.getDate());
        education.setInstitution(education.getInstitution());
        education.setLink(education.getLink());
        education.setTitle(education.getTitle());

        educationserv.save(education);
        return education;
    }
    
}


 