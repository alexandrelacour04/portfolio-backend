package com.backend.controller;

import com.backend.dto.TimelineDTO;
import com.backend.mapper.TimelineMapper;
import com.backend.model.Timeline;
import com.backend.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/timelines")
@CrossOrigin(origins = "http://localhost:5173")
public class TimelineController {
    @Autowired
    private TimelineService timelineService;

    @Autowired
    private TimelineMapper timelineMapper;

    // Récupération paginée
    @GetMapping
    public Page<TimelineDTO> getAllTimelines(Pageable pageable) {
        return timelineService.getAllTimelines(pageable)
                .map(timelineMapper::toDto);
    }

    // Récupération par ID
    @GetMapping("/{id}")
    public ResponseEntity<TimelineDTO> getTimelineById(@PathVariable UUID id) {
        Optional<Timeline> timeline = timelineService.getTimelineById(id);
        return timeline.map(value -> ResponseEntity.ok(timelineMapper.toDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Création
    @PostMapping
    public TimelineDTO createTimeline(@RequestBody TimelineDTO timelineDTO) {
        Timeline timeline = timelineMapper.toEntity(timelineDTO);
        return timelineMapper.toDto(timelineService.createTimeline(timeline));
    }

    // Mise à jour
    @PutMapping("/{id}")
    public ResponseEntity<TimelineDTO> updateTimeline(@PathVariable UUID id, @RequestBody TimelineDTO timelineDTO) throws Exception {
        Timeline timeline = timelineMapper.toEntity(timelineDTO);
        return ResponseEntity.ok(timelineMapper.toDto(timelineService.updateTimeline(id, timeline)));
    }

    // Suppression
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeline(@PathVariable UUID id) {
        timelineService.deleteTimeline(id);
        return ResponseEntity.noContent().build();
    }
}