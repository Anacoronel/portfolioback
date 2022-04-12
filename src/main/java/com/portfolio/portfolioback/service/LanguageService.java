package com.portfolio.portfolioback.service;
import com.portfolio.portfolioback.entity.Person;


import com.portfolio.portfolioback.dto.LanguageDto;
import com.portfolio.portfolioback.entity.Language;
import com.portfolio.portfolioback.repository.LanguageRepository;
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


    public List<Language> list(){
        return languageRepository.findAll();
    }

    public Optional<Language> getOne(int id){
        return languageRepository.findById(id);
    }

    public void  save(LanguageDto languageDto, Person person){
        Language language= new Language();
        language.setLanguages(languageDto.getLanguages());
        language.setLevel(languageDto.getLevel());
        language.setPerson(person);
        languageRepository.save(language);
    }

    public void delete(int id){
        languageRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return languageRepository.existsById(id);
    }
}
    

