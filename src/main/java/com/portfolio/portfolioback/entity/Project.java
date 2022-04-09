package com.portfolio.portfolioback.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String link;
    private String text;
    private String techs;
    @JsonIgnoreProperties("project")
    @ManyToOne(optional = false)
    private Person person;

    public Project(){}

    public Project(String date, String link, String text,  String techs,  Person person) {
        this.date = date;
        this.techs = techs;
        this.link = link;
        this.text = text;
        this.person = person;
    }
}