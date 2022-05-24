package com.trialdex.dex.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trialdex.dex.models.Orientation;
import com.trialdex.dex.models.TrialSubjectMap;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDateTime dob;
    private Orientation orientation;
    private String hospitalId;
    private Integer groupId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<TrialSubjectMap> belongsTo;
}
