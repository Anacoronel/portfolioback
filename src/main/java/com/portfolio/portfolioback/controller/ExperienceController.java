package com.portfolio.portfolioback.controller;


import com.portfolio.portfolioback.entity.Experience;
import com.portfolio.portfolioback.service.iExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/experience")


public class ExperienceController {
   
    @Autowired

    private iExperienceService experienceserv;



    
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
	public Optional<Experience> getOne(@PathVariable Long id){
            return experienceserv.getOne(id);
             
        }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        experienceserv.delete(id);
    }
    @PutMapping("/edit/{id}")
    public Experience edit(@PathVariable Long id,@RequestBody Experience experience){
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


 