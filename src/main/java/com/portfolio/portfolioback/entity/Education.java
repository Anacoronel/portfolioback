package com.portfolio.portfolioback.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String title;
    private String institution;
    private String link;



    public Education(){}

    public Education(String date, String title, String institution, String link) {
        this.title = title;
        this.institution = institution;
        this.date = date;
        this.link = link;
    }
}