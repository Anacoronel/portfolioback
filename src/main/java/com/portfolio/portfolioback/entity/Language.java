package com.portfolio.portfolioback.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity

public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String languages;
    private String level;

    @JsonIgnoreProperties("language")
    @ManyToOne(optional = false)
    private Person person;

    public Language(){}

    public Language(String languages, String level, Person person) {
        this.languages = languages;
        this.level = level;
        this.person = person;
    }
}