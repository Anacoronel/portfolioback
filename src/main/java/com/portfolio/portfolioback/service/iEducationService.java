package com.portfolio.portfolioback.service;

import java.util.List;

import com.portfolio.portfolioback.entity.Education;

public interface iEducationService {
    public List<Education> list();
    public Education getOne(int id);
    public void  save(Education education);
    public void delete(int id);
    public boolean existsById(int id);
    public List<Education> listByUserId(int id);
}
