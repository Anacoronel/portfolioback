package com.portfolio.portfolioback.service;

import com.portfolio.portfolioback.entity.Language;

import java.util.List;
import java.util.Optional;

public interface iLanguageService {
    public List<Language> list();
    public Optional<Language> getOne(int id);
    public void  save(Language language);
    public void delete(int id);
    public boolean existsById(int id);
}
