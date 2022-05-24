package com.trialdex.dex.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trialdex.dex.models.TrialSubjectMap;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrialDto {

    private Long id;
    private Long ownerId;
    private String name;
    private String description;
    private Integer groupCount;
    private Integer subjectCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isActive;
    private Set<TrialSubjectMap> subjects;
}
