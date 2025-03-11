package com.backend.mapper;

import com.backend.dto.TimelineDTO;
import com.backend.model.Timeline;
import org.springframework.stereotype.Component;

@Component
public class TimelineMapper {

    public TimelineDTO toDto(Timeline timeline) {
        TimelineDTO dto = new TimelineDTO();
        dto.setId(timeline.getId());
        dto.setTitre(timeline.getTitre());
        dto.setSousTitre(timeline.getSousTitre());
        dto.setDescription(timeline.getDescription());
        dto.setType(timeline.getType());
        dto.setDate(timeline.getDate());
        return dto;
    }

    public Timeline toEntity(TimelineDTO dto) {
        Timeline timeline = new Timeline();
        timeline.setId(dto.getId());
        timeline.setTitre(dto.getTitre());
        timeline.setSousTitre(dto.getSousTitre());
        timeline.setDescription(dto.getDescription());
        timeline.setType(dto.getType());
        timeline.setDate(dto.getDate());
        return timeline;
    }
}