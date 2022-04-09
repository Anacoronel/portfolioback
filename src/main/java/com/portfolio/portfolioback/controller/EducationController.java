package com.portfolio.portfolioback.controller;


import com.portfolio.portfolioback.entity.Education;
import com.portfolio.portfolioback.service.iEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/education")


public class EducationController {
   
    @Autowired

    private iEducationService educationserv;



    
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


 