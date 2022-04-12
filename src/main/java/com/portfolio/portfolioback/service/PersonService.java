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

    public Optional<Person> getOne(int id){
        return personRepository.findById(id);
    }


    public void save(Person person){
        personRepository.save(person);
    }

    public void delete(int id){
        personRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return personRepository.existsById(id);
    }
}