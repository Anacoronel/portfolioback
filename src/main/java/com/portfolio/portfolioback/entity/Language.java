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
    private String language;
    private String level;

    @JsonIgnoreProperties("language")
    @ManyToOne(optional = false)
    private Person person;

    public Language(){}

    public Language(String language, String level, Person person) {
        this.language = language;
        this.level = level;
        this.person = person;
    }
}