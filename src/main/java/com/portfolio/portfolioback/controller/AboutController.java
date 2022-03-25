package com.portfolio.portfolioback.controller;

import java.util.ArrayList;
import java.util.List;

import com.portfolio.portfolioback.entity.About;
import com.portfolio.portfolioback.service.iAboutService;

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
@RequestMapping("/about")


public class AboutController {
    




    @Autowired
    private iAboutService aboutserv;


    List<About> listaAcercade  = new ArrayList<>();
    
    
    @PostMapping("/new")
    public About save(@RequestBody About about){
        aboutserv.save(about);
        return about;
    }
    

    public void setAboutserv(iAboutService aboutserv) {
        this.aboutserv = aboutserv;
    }

    @GetMapping("/")
    @ResponseBody
    public List<About> list(){
        return aboutserv.list();
    }
    
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        aboutserv.delete(id);
    }

    @PutMapping("/edit/{id}")
    public About edit(@PathVariable Integer id, @RequestBody About about){
        aboutserv.getOne(id);
        about.setText(about.getText());
        aboutserv.save(about);
        return about;
    }
   
}


