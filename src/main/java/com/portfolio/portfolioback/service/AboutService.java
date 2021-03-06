package com.portfolio.portfolioback.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.portfolio.portfolioback.entity.About;
import com.portfolio.portfolioback.repository.AboutRepository;

@Service
@Transactional
public class AboutService implements iAboutService {

    @Autowired
    AboutRepository aboutRepository;
    @Override
    public List<About> list(){
        return aboutRepository.findAll();
    }
    @Override
    public About getOne(int id){
        return aboutRepository.findById(id).orElse(null);
    }
    
    @Override
    public void  save(About about){
        aboutRepository.save(about);
    }
    @Override
    public void delete(int id){
        aboutRepository.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return aboutRepository.existsById(id);
    }
    public List<About> listByUserId(int id) {
        return aboutRepository.findByUserId(id);
    }
   
}