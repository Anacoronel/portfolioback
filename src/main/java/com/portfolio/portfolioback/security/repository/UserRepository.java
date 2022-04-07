package com.portfolio.portfolioback.security.repository;


import com.portfolio.portfolioback.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameOrEmail(String username, String email);
    boolean existsByUsername(String username);
    boolean existsByUsernameOrEmail(String username, String email);
    Optional<User> findByTokenPassword(String tokenPassword);

    boolean existsByEmail(String email);
}