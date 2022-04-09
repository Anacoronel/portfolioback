package com.portfolio.portfolioback.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String title;
    private String institution;
    private String link;


    @JsonIgnoreProperties("education")
    @ManyToOne(optional = false)
    private Person person;

    public Education(){}

    public Education(String date, String title, String institution, String link, Person person) {
        this.title = title;
        this.institution = institution;
        this.date = date;
        this.link = link;
        this.person=person;
    }
}