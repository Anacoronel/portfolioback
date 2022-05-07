package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Person;

import java.util.List;
import java.util.Optional;

public interface iPersonService {
    public List<Person> list();
    public Optional<Person> getOne(Long id);
    public void  save(Person person);
    public void delete(Long id);
    public boolean existsById(Long id);

}
