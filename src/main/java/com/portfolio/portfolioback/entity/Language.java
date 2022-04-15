package com.portfolio.portfolioback.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Person person;

    public Language(){}





    public int getId() {
        return id;
    }
    public Person getPerson() {
        return person;
    }



    public void setPerson(Person person) {
        this.person = person;
    }

}