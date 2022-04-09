package com.portfolio.portfolioback.controller;

import com.portfolio.portfolioback.entity.About;
import com.portfolio.portfolioback.service.iAboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@CrossOrigin(origins = "*")
@RequestMapping("/about")


public class AboutController {
    




    @Autowired
    private iAboutService aboutserv;



    
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


