package com.backend.service;

import com.backend.model.UserInfo;
import com.backend.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    // Créer un nouvel utilisateur
    public UserInfo createUser(UserInfo user) {
        return userInfoRepository.save(user);
    }

    // Récupérer un utilisateur par ID
    public Optional<UserInfo> getUserById(UUID id) {
        return userInfoRepository.findById(id);
    }

    // Récupérer tous les utilisateurs
    public Iterable<UserInfo> getAllUsers() {
        return userInfoRepository.findAll();
    }

    // Mettre à jour un utilisateur
    public UserInfo updateUser(UUID id, UserInfo user) throws Exception {
        Optional<UserInfo> existingUser = userInfoRepository.findById(id);

        if (existingUser.isPresent()) {
            user.setId(id); // On conserve l'ID
            return userInfoRepository.save(user);
        } else {
            throw new Exception("Utilisateur non trouvé !");
        }
    }

    // Supprimer un utilisateur par ID
    public void deleteUser(UUID id) {
        userInfoRepository.deleteById(id);
    }
}