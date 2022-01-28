package com.trialdex.dex.services;

import com.trialdex.dex.models.Subject;
import com.trialdex.dex.repositories.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService implements ISubjectService {

    private final ISubjectRepository subjectRepository;
    private final ITrialManagement trialManagement;

    @Autowired
    public SubjectService(ISubjectRepository subjectRepository, ITrialManagement trialManagement) {
        this.subjectRepository = subjectRepository;
        this.trialManagement = trialManagement;
    }

    @Override
    public Subject createSubject(Subject subject, Long trialId) {
        Subject newSubject = subjectRepository.save(subject);
        trialManagement.addSubjectToTrial(newSubject, trialId);
        return newSubject;
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findSubjectById(id);
    }
}
