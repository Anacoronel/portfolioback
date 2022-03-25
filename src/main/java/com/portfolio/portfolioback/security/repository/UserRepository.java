package com.portfolio.portfolioback.security.repository;


import java.util.Optional;

import com.portfolio.portfolioback.security.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByTokenPassword(String tokenPassword);
    boolean existsByUsername(String username);
    boolean existsByUsernameOrEmail(String username, String email);
    boolean existsByEmail(String email);
}