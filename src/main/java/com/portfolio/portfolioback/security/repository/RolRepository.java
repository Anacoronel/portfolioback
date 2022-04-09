package com.portfolio.portfolioback.security.repository;


import com.portfolio.portfolioback.security.entity.Rol;
import com.portfolio.portfolioback.security.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolName(RolName rolName);
}