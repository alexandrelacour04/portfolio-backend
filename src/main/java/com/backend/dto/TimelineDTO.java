package com.backend.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class TimelineDTO {
    private UUID id;
    private String titre;
    private String sousTitre;
    private String description;
    private String type;
    private String cusomIcon;
    private Date date;
}