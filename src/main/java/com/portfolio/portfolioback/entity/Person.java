package com.portfolio.portfolioback.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@JsonComponent
public class  Person {

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


    @JsonIgnoreProperties("person")
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Language> languages = new HashSet<>();

    @JsonIgnoreProperties("person")
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<About> abouts = new HashSet<>();
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
    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Set<About> getAbouts() {
        return abouts;
    }

    public void setAbouts(Set<About> abouts) {
        this.abouts = abouts;
    }



}