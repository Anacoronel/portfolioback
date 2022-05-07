package com.portfolio.portfolioback.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter

public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String company;
    private String link;
    private String startTime;
    private String endTime;



    public Experience(){}

    public Experience(String position, String company, String link, String startTime, String endTime){
        this.position = position;
        this.company = company;
        this.link = link;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

