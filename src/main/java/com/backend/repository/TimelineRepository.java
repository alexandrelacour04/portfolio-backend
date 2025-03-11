package com.backend.repository;

import com.backend.model.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TimelineRepository extends JpaRepository<Timeline, UUID>, JpaSpecificationExecutor<Timeline> {
    // Ajoutez des requêtes spécifiques si besoin, par exemple :
    // Optional<Timeline> findByTitre(String titre);
    List<Timeline> findByType(String type);
    List<Timeline> findByDateBetween(Date startDate, Date endDate);

}