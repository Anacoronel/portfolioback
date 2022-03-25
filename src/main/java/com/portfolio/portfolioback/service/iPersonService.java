package com.portfolio.portfolioback.service;

import java.util.List;

import com.portfolio.portfolioback.entity.Person;

public interface iPersonService {
    public List<Person> list();
    public Person getOne(int id);
    public void  save(Person person);
    public void delete(int id);
    public boolean existsById(int id);
    public List<Person> listByUserId(int id);
}
