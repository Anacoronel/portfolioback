package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Person;
import com.portfolio.portfolioback.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
        return (Person) personRepository.findByUserId(id);
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