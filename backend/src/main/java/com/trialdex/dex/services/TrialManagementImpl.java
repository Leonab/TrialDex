package com.trialdex.dex.services;

import com.trialdex.dex.models.Subject;
import com.trialdex.dex.models.Trial;
import com.trialdex.dex.models.TrialSubjectMap;
import com.trialdex.dex.repositories.ITrialRepository;
import com.trialdex.dex.repositories.ITrialSubjectMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TrialManagementImpl implements ITrialManagement {

    private final ITrialRepository trialRepository;
    private final ITrialSubjectMapRepository trialSubjectMapRepository;

    @Override
    @Transactional
    public void addSubjectToTrial(Subject subject, Long trialId) {
        Trial trial = trialRepository.getById(trialId);
        TrialSubjectMap map = new TrialSubjectMap();
        map.setSubject(subject);
        map.setTrial(trial);
        trialSubjectMapRepository.save(map);
    }
}
