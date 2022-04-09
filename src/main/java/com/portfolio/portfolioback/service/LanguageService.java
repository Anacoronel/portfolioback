package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Language;
import com.portfolio.portfolioback.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LanguageService implements iLanguageService {
    
    @Autowired
    LanguageRepository languageRepository;
    @Override
    public List<Language> list(){
        return languageRepository.findAll();
    }
    @Override
    public Language getOne(int id){
        return (Language) languageRepository.findByUserId(id);
    }
    
    @Override
    public void  save(Language language){
        languageRepository.save(language);
    }
    @Override
    public void delete(int id){
        languageRepository.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return languageRepository.existsById(id);
    }
    public List<Language> listByUserId(int id) {
        return languageRepository.findByUserId(id);
    }
   
}
    

