package com.trialdex.dex.services;

import com.trialdex.dex.models.Subject;

public interface ISubjectService {

    Subject createSubject(Subject subject, Long trialId);

    Subject findById(Long id);
}
