package com.trialdex.dex.services;

import com.trialdex.dex.models.Trial;

import java.util.List;

public interface ITrialService {

    Trial createTrial(Trial trial);

    List<Trial> getTrialsByOwnerId(Long id);
}
