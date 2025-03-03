package com.backend.controller;

import com.backend.model.UserInfo;
import com.backend.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserInfoController {

    @Autowired
    private UserInfoService userService;

    // Créer un nouvel utilisateur
    @PostMapping
    public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> getUserById(@PathVariable UUID id) {
        Optional<UserInfo> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Récupérer tous les utilisateurs
    @GetMapping
    public ResponseEntity<Iterable<UserInfo>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Mettre à jour un utilisateur
    @PutMapping("/{id}")
    public ResponseEntity<UserInfo> updateUser(@PathVariable UUID id, @RequestBody UserInfo user) {
        try {
            return ResponseEntity.ok(userService.updateUser(id, user));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}