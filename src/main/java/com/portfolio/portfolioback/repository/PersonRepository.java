package com.portfolio.portfolioback.repository;
import java.util.List;

import com.portfolio.portfolioback.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByUserId(int Userid);

}
