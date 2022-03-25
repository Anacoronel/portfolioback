package com.portfolio.portfolioback.controller;



import java.util.ArrayList;
import java.util.List;

import com.portfolio.portfolioback.entity.Person;
import com.portfolio.portfolioback.service.iPersonService;

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
@RequestMapping("/person")


public class PersonController {
   
    @Autowired

    private iPersonService personserv;


    List<Person> listpersons = new ArrayList<>();
    
    
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


 