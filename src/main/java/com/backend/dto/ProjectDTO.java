package com.backend.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ProjectDTO {
    private UUID id;
    private String title;
    private String subtitle;
    private String description;

    private String tags;
    private String technologies;

    private String status;
    private String type;
    private Date startDate;
    private Date endDate;
    private String coverImage;

    private String liveUrl;
    private String repositoryUrl;
    private Boolean isPublic;
    private String client;
}