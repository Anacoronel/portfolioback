package com.portfolio.portfolioback.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity

public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;


    @JsonIgnoreProperties("about")
    @ManyToOne(optional = false)
    private Person person;

    public About(){}

    public About(String text, Person person) {
        this.text = text;
        this.person=person;
    }
}