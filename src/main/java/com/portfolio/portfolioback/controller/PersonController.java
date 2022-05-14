package com.portfolio.portfolioback.controller;


import com.portfolio.portfolioback.entity.Person;
import com.portfolio.portfolioback.service.iPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/person")


public class PersonController {
   
    @Autowired

    private iPersonService personserv;




    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public Person save(@RequestBody Person person){
        personserv.save(person);
        return person;
    }
    

    public void setPersonService(iPersonService personserv) {
        this.personserv = personserv;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Person> list(){
        return personserv.list();
    }
    @GetMapping("/{id}")
	public Optional<Person> getOne(@PathVariable Long id){
            return personserv.getOne(id);
             
        }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        personserv.delete(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Person edit(@PathVariable Long id,@RequestBody Person person){
         personserv.getOne(id);
        
        person.setName(person.getName());
        person.setDescription(person.getDescription());
        person.setCity(person.getCity());
        person.setCountry(person.getCountry());
        person.setEmail(person.getEmail());
        person.setBackImg(person.getBackImg());
        person.setProfileImg(person.getProfileImg());

        personserv.save(person);
        return person;
    }
    
}


 