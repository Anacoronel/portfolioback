package com.portfolio.portfolioback.service;

import java.util.List;

import com.portfolio.portfolioback.entity.About;

public interface iAboutService {
    

    



    public List<About> list();
    public About getOne(int id);
    public void  save(About about);
    public void delete(int id);
    public boolean existsById(int id);
    public List<About> listByUserId(int id);



    
    

  
    
    
   
   
}