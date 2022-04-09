package com.portfolio.portfolioback.controller;


import com.portfolio.portfolioback.entity.Person;
import com.portfolio.portfolioback.service.iPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/person")


public class PersonController {
   
    @Autowired

    private iPersonService personserv;





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
	public  Person getOne(@PathVariable Integer id){
            return personserv.getOne(id);
             
        }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        personserv.delete(id);
    }
    @PutMapping("/edit/{id}")
    public Person edit(@PathVariable Integer id,@RequestBody Person person){
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


 