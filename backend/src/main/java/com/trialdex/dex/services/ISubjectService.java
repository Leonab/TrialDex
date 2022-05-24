package com.trialdex.dex.services;

import com.trialdex.dex.models.Subject;

import java.util.List;

public interface ISubjectService {

    Subject createSubject(Subject subject, Long trialId);

    Subject findById(Long id);

    List<Subject> findSubjectsByTrialId(Long trialId);
}
