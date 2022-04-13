package com.portfolio.portfolioback.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;

@Getter
@Setter
@Entity
@JsonComponent

public class Language {

    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String languages;
    private String level;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @JsonIgnoreProperties("language")
    @ManyToOne(optional = false)
    @JoinColumn(name="person_id", referencedColumnName = "id")
    private Person person;

    public Language(){}

    public Language(String languages, String level, Person person) {
        this.languages = languages;
        this.level = level;
        this.person = person;
    }


}