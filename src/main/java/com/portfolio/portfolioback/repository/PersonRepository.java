package com.portfolio.portfolioback.repository;

import com.portfolio.portfolioback.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Override
    Optional<Person> findById(Long id);

    @Override
    Person getById(Long id);
}
