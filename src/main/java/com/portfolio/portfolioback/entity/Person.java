package com.portfolio.portfolioback.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String city;
    private String country;
    private String email;
    private String backImg;
    private String profileImg;
    
    @JsonIgnoreProperties("person")
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Experience> experiences = new HashSet<>();

    @JsonIgnoreProperties("person")
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Education> educations = new HashSet<>();

    @JsonIgnoreProperties("person")
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Project> projects = new HashSet<>();

    @JsonIgnoreProperties("person")
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Skill> skills = new HashSet<>();

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