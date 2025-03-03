package com.backend.repository;

import com.backend.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {
    // Une méthode pour trouver un utilisateur par son nom d'utilisateur
    Optional<UserInfo> findByUsername(String username);
}