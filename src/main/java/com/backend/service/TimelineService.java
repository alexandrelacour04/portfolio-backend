package com.backend.service;

import com.backend.model.Timeline;
import com.backend.repository.TimelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TimelineService {
    @Autowired
    private TimelineRepository timelineRepository;

    // Récupération de toutes les entités paginées
    public Page<Timeline> getAllTimelines(Pageable pageable) {
        return timelineRepository.findAll(pageable);
    }

    // Récupération d'une seule entité par ID
    public Optional<Timeline> getTimelineById(UUID id) {
        return timelineRepository.findById(id);
    }

    // Création d'une nouvelle entité
    public Timeline createTimeline(Timeline timeline) {
        return timelineRepository.save(timeline);
    }

    // Mise à jour d'une entité existante
    public Timeline updateTimeline(UUID id, Timeline timeline) throws Exception {
        Optional<Timeline> existingTimeline = timelineRepository.findById(id);

        if (existingTimeline.isPresent()) {
            timeline.setId(id); // S'assurer que l'ID est conservé
            return timelineRepository.save(timeline);
        } else {
            throw new Exception("Timeline non trouvée !");
        }
    }

    // Suppression d'une entité par ID
    public void deleteTimeline(UUID id) {
        timelineRepository.deleteById(id);
    }
}