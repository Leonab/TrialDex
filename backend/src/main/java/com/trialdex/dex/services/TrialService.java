package com.trialdex.dex.services;

import com.trialdex.dex.models.Trial;
import com.trialdex.dex.repositories.ITrialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class TrialService implements ITrialService {

    private final ITrialRepository trialRepository;
    private final ITrialManagement trialManagement;

    @Autowired
    public TrialService(ITrialRepository trialRepository, ITrialManagement trialManagement) {
        this.trialRepository = trialRepository;
        this.trialManagement = trialManagement;
    }

    @Override
    public List<Trial> getTrialsByOwnerId(Long id) {
        return trialRepository.findTrialsByOwnerId(id);
    }

    @Override
    public Trial getTrialById(Long id) {
        return trialRepository.findTrialById(id);
    }

    @Override
    public Trial createTrial(Trial trial) {
        Trial newTrial = trialRepository.save(trial);
        if (Objects.isNull(newTrial.getOwnerId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Owner id cannot be null");
        }
        trialManagement.addTrialToUser(newTrial, newTrial.getOwnerId());
        return newTrial;
    }
}
