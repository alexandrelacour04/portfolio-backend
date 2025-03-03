package com.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Size(max = 255)
    private String title;

    @Size(max = 255)
    private String subtitle;

    @Lob
    private String description;

    private String technologies;

    private String status; // Ex: "En cours", "Terminé", etc.

    private String type; // Ex: "Personnel", "Professionnel", "Open Source", etc.

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    private String coverImage; // URL ou chemin vers l'image principale

    private String liveUrl; // Lien vers la démo en ligne

    private String repositoryUrl; // Lien vers le repository

    private Boolean isPublic;

    @Size(max = 255)
    private String client;

    private String tags; // Mots-clés associés au projet
}