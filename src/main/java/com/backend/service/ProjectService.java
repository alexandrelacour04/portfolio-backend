package com.backend.service;

import com.backend.model.Project;
import com.backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    // Récupération paginée de tous les projets
    public Page<Project> getAllProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    // Récupération d'un projet par ID
    public Optional<Project> getProjectById(UUID id) {
        return projectRepository.findById(id);
    }

    // Création d'un nouveau projet
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // Mise à jour d'un projet existant
    public Project updateProject(UUID id, Project project) throws Exception {
        Optional<Project> existingProject = projectRepository.findById(id);

        if (existingProject.isPresent()) {
            project.setId(id); // S'assurer que l'ID est conservé
            return projectRepository.save(project);
        } else {
            throw new Exception("Projet non trouvé !");
        }
    }

    // Suppression d'un projet par ID
    public void deleteProject(UUID id) {
        projectRepository.deleteById(id);
    }
}