package com.backend.mapper;

import com.backend.dto.ProjectDTO;
import com.backend.model.Project;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectMapper {

    // Convertir une entité vers un DTO
    public ProjectDTO toDto(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setTitle(project.getTitle());
        dto.setSubtitle(project.getSubtitle());
        dto.setDescription(project.getDescription());
        dto.setTechnologies(project.getTechnologies());
        dto.setStatus(project.getStatus());
        dto.setType(project.getType());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());
        dto.setCoverImage(project.getCoverImage());
        dto.setLiveUrl(project.getLiveUrl());
        dto.setRepositoryUrl(project.getRepositoryUrl());
        dto.setIsPublic(project.getIsPublic());
        dto.setClient(project.getClient());
        dto.setTags(project.getTags());
        return dto;
    }

    // Convertir un DTO vers une entité
    public Project toEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setId(dto.getId());
        project.setTitle(dto.getTitle());
        project.setSubtitle(dto.getSubtitle());
        project.setDescription(dto.getDescription());
        project.setTechnologies(dto.getTechnologies());
        project.setStatus(dto.getStatus());
        project.setType(dto.getType());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setCoverImage(dto.getCoverImage());

        project.setLiveUrl(dto.getLiveUrl());
        project.setRepositoryUrl(dto.getRepositoryUrl());
        project.setIsPublic(dto.getIsPublic());
        project.setClient(dto.getClient());
        project.setTags(dto.getTags());
        return project;
    }
}