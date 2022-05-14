package com.portfolio.portfolioback.controller;

import com.portfolio.portfolioback.entity.Skill;
import com.portfolio.portfolioback.service.iSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/skill")


public class SkillController {
   
    @Autowired

    private iSkillService skillserv;



    @PreAuthorize("hasRole('ADMIN')")
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
	public Optional<Skill> getOne(@PathVariable Long id){
            return skillserv.getOne(id);
             
        }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        skillserv.delete(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Skill edit(@PathVariable Long id,@RequestBody Skill skill){
         skillserv.getOne(id);
        
        skill.setValue(skill.getValue());
        skill.setText(skill.getText());
        skillserv.save(skill);
        return skill;
    }

   

    
    
}


 