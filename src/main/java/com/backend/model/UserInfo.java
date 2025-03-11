package com.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Size(max = 50)
    private String username; // Nom d'utilisateur unique

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    private String lastName;

    @Size(max = 255)
    private String imagePath; // Chemin d'accès pour l'image de l'utilisateur

    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(min = 8)
    private String password; // Hashé à l'avenir pour l'authentification

    private String role; // Rôle de l'utilisateur, par exemple ADMIN ou USER

    private boolean active = true; // Statut actif/inactif
}