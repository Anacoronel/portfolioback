package com.portfolio.portfolioback.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String link;
    private String text;
    private String techs;

    public Project(){}

    public Project(String date, String link, String text,  String techs) {
        this.date = date;
        this.techs = techs;
        this.link = link;
        this.text = text;
    }
}