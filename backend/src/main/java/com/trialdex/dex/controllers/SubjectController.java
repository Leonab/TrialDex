package com.trialdex.dex.controllers;

import com.trialdex.dex.models.Subject;
import com.trialdex.dex.services.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

    private final ISubjectService subjectService;

    @Autowired
    public SubjectController(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/subject")
    public Subject createSubject(@RequestBody Subject subject, @RequestParam("trialId") Long id) {
        return subjectService.createSubject(subject, id);
    }
}
