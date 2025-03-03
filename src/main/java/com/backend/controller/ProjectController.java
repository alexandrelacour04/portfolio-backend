package com.backend.controller;

import com.backend.dto.ProjectDTO;
import com.backend.mapper.ProjectMapper;
import com.backend.model.Project;
import com.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:5173")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectMapper projectMapper;

    // Liste paginée des projets
    @GetMapping
    public Page<ProjectDTO> getAllProjects(Pageable pageable) {
        return projectService.getAllProjects(pageable)
                .map(projectMapper::toDto);
    }

    // Récupération par ID
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable UUID id) {
        Optional<Project> project = projectService.getProjectById(id);
        return project.map(value -> ResponseEntity.ok(projectMapper.toDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Création
    @PostMapping
    public ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {
        Project project = projectMapper.toEntity(projectDTO);
        return projectMapper.toDto(projectService.createProject(project));
    }

    // Mise à jour
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable UUID id, @RequestBody ProjectDTO projectDTO) throws Exception {
        Project project = projectMapper.toEntity(projectDTO);
        return ResponseEntity.ok(projectMapper.toDto(projectService.updateProject(id, project)));
    }

    // Suppression
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable UUID id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}