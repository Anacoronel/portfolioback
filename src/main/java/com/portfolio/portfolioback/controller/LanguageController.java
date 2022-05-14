package com.portfolio.portfolioback.controller;


import com.portfolio.portfolioback.entity.Language;
import com.portfolio.portfolioback.repository.PersonRepository;
import com.portfolio.portfolioback.service.iLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public Language save(@RequestBody Language language){
        languageserv.save(language);
        return language;
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
	public Optional<Language> getOne(@PathVariable Long id){
            return languageserv.getOne(id);
             
        }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        languageserv.delete(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Language edit(@PathVariable Long id,@RequestBody Language language){
         languageserv.getOne(id);
        
        language.setLevel(language.getLevel());
        language.setLanguages(language.getLanguages());
      
        languageserv.save(language);
        return language;
    }
    
}


 