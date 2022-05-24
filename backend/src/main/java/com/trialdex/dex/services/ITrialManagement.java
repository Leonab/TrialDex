package com.trialdex.dex.services;

import com.trialdex.dex.models.Subject;
import com.trialdex.dex.models.Trial;

public interface ITrialManagement {

    void addSubjectToTrial(Subject subject, Long trialId);
}
