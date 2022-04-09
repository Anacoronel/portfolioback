package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.About;

import java.util.List;
import java.util.Optional;

public interface iAboutService {
    

    



    public List<About> list();
    public Optional<About> getOne(int id);
    public void  save(About about);
    public void delete(int id);



    
    

  
    
    
   
   
}