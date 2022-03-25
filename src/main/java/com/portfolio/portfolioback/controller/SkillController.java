package com.portfolio.portfolioback.controller;

import java.util.ArrayList;
import java.util.List;

import com.portfolio.portfolioback.entity.Skill;
import com.portfolio.portfolioback.service.iSkillService;

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
@RequestMapping("/skill")


public class SkillController {
   
    @Autowired

    private iSkillService skillserv;


    List<Skill> listaSkills  = new ArrayList<>();
    
    
    @PostMapping("/new")
    public Skill save(@RequestBody Skill skill){
        skillserv.save(skill);
        return skill;
    }
    

    public void setSkillserv(iSkillService skillserv) {
        this.skillserv = skillserv;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Skill> list(){
        return skillserv.list();
    }
    @GetMapping("/{id}")
	public  Skill getOne(@PathVariable Integer id){
            return skillserv.getOne(id);
             
        }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        skillserv.delete(id);
    }
    @PutMapping("/edit/{id}")
    public Skill edit(@PathVariable Integer id,@RequestBody Skill skill){
         skillserv.getOne(id);
        
        skill.setValue(skill.getValue());
        skill.setText(skill.getText());
        skillserv.save(skill);
        return skill;
    }

   

    
    
}


 