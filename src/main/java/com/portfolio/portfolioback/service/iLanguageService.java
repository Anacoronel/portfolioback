package com.portfolio.portfolioback.service;

import java.util.List;

import com.portfolio.portfolioback.entity.Language;

public interface iLanguageService {
    public List<Language> list();
    public Language getOne(int id);
    public void  save(Language language);
    public void delete(int id);
    public boolean existsById(int id);
    public List<Language> listByUserId(int id);
}
