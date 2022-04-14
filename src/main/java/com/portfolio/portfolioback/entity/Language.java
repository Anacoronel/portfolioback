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




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String languages;
    private String level;




    @JsonIgnoreProperties("language")
    @ManyToOne(optional = false)
    @JoinColumn(name="person_id", referencedColumnName = "id")
    private Person person;
    private int person_id;

    public Language(){}

    public Language(String languages, String level, int person_id,Person person) {
        this.languages = languages;
        this.level = level;
        this.person = person;
        this.person_id=person_id;
    }

    public Language(String languages, String level, Person person,int person_id) {
    }

    public int getId() {
        return id;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson_id(){
        this.person_id=person_id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}