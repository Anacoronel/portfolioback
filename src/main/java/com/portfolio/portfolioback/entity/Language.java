package com.portfolio.portfolioback.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity

public class Language {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String languages;
    private String level;




    public Language(){}
    public Language(String languages, String level) {
        this.languages = languages;
        this.level=level;
    }




}