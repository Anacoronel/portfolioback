package com.portfolio.portfolioback.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter

public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private Long value;
    @JsonIgnoreProperties("skill")
    @ManyToOne(optional = false)
    private Person person;

    public Skill(){}

    public Skill(String text, Long value, Person person) {
        this.text = text;
        this.value = value;
        this.person = person;
    }
}
