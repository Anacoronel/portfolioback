package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Language;
import com.portfolio.portfolioback.repository.LanguageRepository;
import com.portfolio.portfolioback.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LanguageService implements iLanguageService {
    
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    PersonRepository personRepository;

    public List<Language> list(){
        return languageRepository.findAll();
    }

    public Optional<Language> getOne(int id){
        return languageRepository.findById(id);
    }
    @Override
    public  void save(Language language){
            languageRepository.save(language);


    }

    public void delete(int id){
        languageRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return languageRepository.existsById(id);
    }
}
    

