package com.portfolio.portfolioback.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter

public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String position;
    private String company;
    private String link;
    private String startTime;
    private String endTime;

    @JsonIgnoreProperties("experience")
    @ManyToOne(optional = false)
    private Person person;

    public Experience(){}

    public Experience(String position, String company, String link, String startTime, String endTime,Person person){
        this.position = position;
        this.company = company;
        this.link = link;
        this.startTime = startTime;
        this.endTime = endTime;
        this.person = person;
    }
}

