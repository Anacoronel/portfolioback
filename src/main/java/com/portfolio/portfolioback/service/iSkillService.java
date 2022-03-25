package com.portfolio.portfolioback.service;

import java.util.List;

import com.portfolio.portfolioback.entity.Skill;

public interface iSkillService {
    public List<Skill> list();
    public Skill getOne(int id);
    public void  save(Skill skill);
    public void delete(int id);
    public boolean existsById(int id);
    public List<Skill> listByUserId(int id);
}
