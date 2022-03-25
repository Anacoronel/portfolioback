package com.portfolio.portfolioback.controller;



import java.util.ArrayList;
import java.util.List;

import com.portfolio.portfolioback.entity.Experience;
import com.portfolio.portfolioback.service.iExperienceService;

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
@RequestMapping("/experience")


public class ExperienceController {
   
    @Autowired

    private iExperienceService experienceserv;


    List<Experience> listExperiences = new ArrayList<>();
    
    
    @PostMapping("/new")
    public Experience save(@RequestBody Experience experience){
        experienceserv.save(experience);
        return experience;
    }
    

    public void setExperienceService(iExperienceService experienceserv) {
        this.experienceserv = experienceserv;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Experience> list(){
        return experienceserv.list();
    }
    @GetMapping("/{id}")
	public  Experience getOne(@PathVariable Integer id){
            return experienceserv.getOne(id);
             
        }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        experienceserv.delete(id);
    }
    @PutMapping("/edit/{id}")
    public Experience edit(@PathVariable Integer id,@RequestBody Experience experience){
         experienceserv.getOne(id);
        
        experience.setPosition(experience.getPosition());
        experience.setCompany(experience.getCompany());
        experience.setLink(experience.getLink());
        experience.setEndTime(experience.getEndTime());
        experience.setStartTime(experience.getStartTime());

        experienceserv.save(experience);
        return experience;
    }
    
}


 