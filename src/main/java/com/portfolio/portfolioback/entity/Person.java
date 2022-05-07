package com.portfolio.portfolioback.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class  Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String city;
    private String country;
    private String email;
    private String backImg;
    private String profileImg;

    public Person() {

    }

    public Person(String name, String description, String city, String country, String email, String backImg, String profileImg) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.country = country;
        this.email = email;
        this.backImg = backImg;
        this.profileImg=profileImg;
    }

}