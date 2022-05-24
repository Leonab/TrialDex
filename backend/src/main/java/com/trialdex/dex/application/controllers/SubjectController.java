package com.trialdex.dex.application.controllers;

import com.trialdex.dex.application.dto.SubjectDto;
import com.trialdex.dex.application.mappers.SubjectMapper;
import com.trialdex.dex.models.Subject;
import com.trialdex.dex.services.ISubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SubjectController {

    private final ISubjectService subjectService;
    private final SubjectMapper mapper;

    @GetMapping("/subject/{id}")
    public SubjectDto getSubject(@PathVariable Long id) {
        Subject subject = subjectService.findById(id);
        if (Objects.nonNull(subject)) {
            return mapper.subjectToSubjectDto(subject);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject with id: " + id + " not found");
    }

    @PostMapping("/subject")
    public SubjectDto createSubject(@RequestBody SubjectDto subject, @RequestParam("trialId") Long trialId) {
        Subject requestSubject = mapper.subjectDtoToSubject(subject);
        Subject newSubject = subjectService.createSubject(requestSubject, trialId);
        return mapper.subjectToSubjectDto(newSubject);
    }

    @GetMapping("/subject")
    public List<SubjectDto> getSubjectsByTrial(@RequestParam("trialId") Long trialId) {
        return subjectService.findSubjectsByTrialId(trialId).stream()
                .map(mapper::subjectToSubjectDto)
                .collect(Collectors.toList());
    }
}
