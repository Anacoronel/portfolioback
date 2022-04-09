package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Skill;

import java.util.List;
import java.util.Optional;

public interface iSkillService {
    public List<Skill> list();
    public Optional<Skill> getOne(int id);
    public void  save(Skill skill);
    public void delete(int id);
    public boolean existsById(int id);

}
