package com.trialdex.dex.controllers;

import com.trialdex.dex.models.Trial;
import com.trialdex.dex.services.ITrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
public class TrialController {

    private final ITrialService trialService;

    @Autowired
    public TrialController(ITrialService trialService) {
        this.trialService = trialService;
    }

    @GetMapping("/trial/{id}")
    public Trial getTrial(@PathVariable Long id) {
        Trial trial = trialService.getTrialById(id);
        if (Objects.nonNull(trial)) {
            return trial;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trial with id: " + id + " not found");
    }

    @GetMapping("/trial")
    public List<Trial> getTrialsByOwner(@RequestParam("ownerId") Long id) {
        return trialService.getTrialsByOwnerId(id);
    }

    @PostMapping("/trial")
    public Long createNewTrial(@RequestBody Trial trial) {
        Trial newTrial = trialService.createTrial(trial);
        if (Objects.nonNull(newTrial)) {
            return newTrial.getId();
        }

        throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Failed to create new trial");
    }
}
