package com.portfolio.portfolioback.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;
import java.util.Optional;

@Getter
@Setter
@Entity
@JsonComponent

public class Language {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String languages;
    private String level;


    public Optional<Person> getPerson() {
        return person;
    }

    public void setPerson(Optional<Person> person) {
        this.person = person;
    }

    @JsonIgnoreProperties("language")
    @ManyToOne(optional = false)
    @JoinColumn(name="person_id", referencedColumnName = "id")
    private Optional<Person> person;

    public Language(){}

    public Language(String languages, String level, Optional<Person> person) {
        this.languages = languages;
        this.level = level;
        this.person = person;
    }

    public Language(String languages, String level, int person_id) {
    }

    public int getId() {
        return id;
    }

}