package com.backend.repository;

import com.backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID>, JpaSpecificationExecutor<Project> {
    List<Project> findByStatus(String status);
    List<Project> findByType(String type);
    List<Project> findByIsPublic(Boolean isPublic);
}