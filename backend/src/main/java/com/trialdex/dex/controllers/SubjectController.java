package com.trialdex.dex.controllers;

import com.trialdex.dex.models.Subject;
import com.trialdex.dex.services.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
public class SubjectController {

    private final ISubjectService subjectService;

    @Autowired
    public SubjectController(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subject/{id}")
    public Subject getSubject(@PathVariable Long id) {
        Subject subject = subjectService.findById(id);
        if (Objects.nonNull(subject)) {
            return subject;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject with id: " + id + " not found");
    }

    @PostMapping("/subject")
    public Subject createSubject(@RequestBody Subject subject, @RequestParam("trialId") Long id) {
        return subjectService.createSubject(subject, id);
    }
}
