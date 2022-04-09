package com.portfolio.portfolioback.service;


import com.portfolio.portfolioback.entity.About;
import com.portfolio.portfolioback.repository.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AboutService implements iAboutService {

    @Autowired
    AboutRepository aboutRepository;

    public List<About> list(){
        return aboutRepository.findAll();
    }

    public Optional<About> getOne(int id){
        return aboutRepository.findById(id);
    }

    public void  save(About about){
        aboutRepository.save(about);
    }

    public void delete(int id){
        aboutRepository.deleteById(id);
    }


}