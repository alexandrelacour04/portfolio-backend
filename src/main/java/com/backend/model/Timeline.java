package com.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Timeline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Size(max = 255)
    private String titre;

    @Size(max = 255)
    private String sousTitre;

    private String customIcone;

    @Lob // Permet de stocker un texte long
    private String description;

    @NotNull
    private String type;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Lob
    private String paragraphe;
}