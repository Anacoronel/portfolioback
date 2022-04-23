package com.portfolio.portfolioback.controller;


import com.portfolio.portfolioback.entity.Language;
import com.portfolio.portfolioback.entity.Person;
import com.portfolio.portfolioback.repository.PersonRepository;
import com.portfolio.portfolioback.service.iLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/language")


public class LanguageController {
   
    @Autowired

    private iLanguageService languageserv;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/new")
    public Language save(@RequestBody Language language) {
        Person person= new Person();
        person.getLanguages().add(language);

      /*  Language language=new Language();
        language.setLanguages(language.getLanguages());
        language.setLevel(language.getLevel());
        language.setPerson(personService.getOne(id).get());*/


        languageserv.save(language); return language;

    }




    public void setLanguageService(iLanguageService languageserv) {
        this.languageserv = languageserv;
    }



    @GetMapping("/")
    @ResponseBody
    public List<Language> list(){
        return languageserv.list();
    }
    @GetMapping("/{id}")
	public Optional<Language> getOne(@PathVariable Integer id){
            return languageserv.getOne(id);
             
        }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        languageserv.delete(id);
    }
    @PutMapping("/edit/{id}")
    public Language edit(@PathVariable Integer id,@RequestBody Language language){
         languageserv.getOne(id);
        
        language.setLevel(language.getLevel());
        language.setLanguages(language.getLanguages());
      
        languageserv.save(language);
        return language;
    }
    
}


 