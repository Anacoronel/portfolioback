package com.portfolio.portfolioback.controller;


import com.portfolio.portfolioback.entity.Language;
import com.portfolio.portfolioback.service.iLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/language")


public class LanguageController {
   
    @Autowired

    private iLanguageService languageserv;


    List<Language> listaLanguage  = new ArrayList<>();

    
    @PostMapping("/new")
    public Language save(@RequestBody Language language){
        languageserv.save(language);
        return language;
    }
    

    public void setEducationService(iLanguageService languageserv) {
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


 