package com.portfolio.portfolioback.service;

import java.util.List;

import com.portfolio.portfolioback.entity.Person;
import com.portfolio.portfolioback.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PersonService implements iPersonService {

    @Autowired
    PersonRepository personRepository;
    @Override
    public List<Person> list(){
        return personRepository.findAll();
    }
    @Override
    public Person getOne(int id){
        return personRepository.findById(id).orElse(null);
    }
    
    @Override
    public void  save(Person person){
        personRepository.save(person);
    }
    @Override
    public void delete(int id){
        personRepository.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return personRepository.existsById(id);
    }
    public List<Person> listByUserId(int id) {
        return personRepository.findByUserId(id);
    }
   
}