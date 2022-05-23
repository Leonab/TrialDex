package com.trialdex.dex.application.controllers;

import com.trialdex.dex.application.dto.TrialDto;
import com.trialdex.dex.application.mappers.TrialMapper;
import com.trialdex.dex.models.Trial;
import com.trialdex.dex.services.ITrialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TrialController {

    private final ITrialService trialService;
    private final TrialMapper mapper;

    @GetMapping("/trial/{id}")
    public TrialDto getTrial(@PathVariable Long id) {
        Trial trial = trialService.getTrialById(id);
        if (Objects.nonNull(trial)) {
            return mapper.trialToTrialDto(trial);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trial with id: " + id + " not found");
    }

    @GetMapping("/trial")
    public List<TrialDto> getTrialsByOwner(@RequestParam("ownerId") Long id) {
        return trialService.getTrialsByOwnerId(id).stream()
                .map(mapper::trialToTrialDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/trial")
    public Long createNewTrial(@RequestBody TrialDto trial) {
        Trial requestTrial = mapper.trialDtoToTrial(trial);
        Trial newTrial = trialService.createTrial(requestTrial);
        if (Objects.nonNull(newTrial)) {
            return newTrial.getId();
        }

        throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Failed to create new trial");
    }
}
