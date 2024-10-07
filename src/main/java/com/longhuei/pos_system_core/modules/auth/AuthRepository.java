package com.longhuei.pos_system_core.modules.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
