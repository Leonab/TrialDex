package com.trialdex.dex.services;

import com.trialdex.dex.models.Subject;
import com.trialdex.dex.models.Trial;
import com.trialdex.dex.models.User;
import com.trialdex.dex.repositories.ISubjectRepository;
import com.trialdex.dex.repositories.ITrialRepository;
import com.trialdex.dex.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TrialManagementImpl implements ITrialManagement {

    private final ITrialRepository trialRepository;
    private final ISubjectRepository subjectRepository;
    private final IUserRepository userRepository;

    @Autowired
    public TrialManagementImpl(ITrialRepository trialRepository, ISubjectRepository subjectRepository, IUserRepository userRepository) {
        this.trialRepository = trialRepository;
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void addTrialToUser(Trial trial, Long userId) {
        User user = userRepository.getById(userId);
        user.getTrials().add(trial);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void addSubjectToTrial(Subject subject, Long trialId) {
        Trial trial = trialRepository.getById(trialId);
        trial.getSubjects().add(subject);
        trialRepository.save(trial);
    }
}
