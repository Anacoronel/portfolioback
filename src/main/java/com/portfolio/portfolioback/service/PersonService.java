package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Person;
import com.portfolio.portfolioback.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PersonService implements iPersonService {

    @Autowired
    PersonRepository personRepository;
    public List<Person> list(){
        return personRepository.findAll();
    }

    public Optional<Person> getOne(Integer id){
        return personRepository.findById(id);
    }


    public void save(Person person){
        personRepository.save(person);
    }

    public void delete(Integer id){
        personRepository.deleteById(id);
    }

    public boolean existsById(Integer id){
        return personRepository.existsById(id);
    }
}