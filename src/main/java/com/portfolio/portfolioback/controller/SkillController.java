package com.portfolio.portfolioback.controller;

import com.portfolio.portfolioback.entity.Skill;
import com.portfolio.portfolioback.service.iSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/skill")


public class SkillController {
   
    @Autowired

    private iSkillService skillserv;



    
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


 