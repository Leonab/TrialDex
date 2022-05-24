package com.trialdex.dex.application.mappers;

import com.trialdex.dex.application.dto.TrialDto;
import com.trialdex.dex.models.Trial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TrialMapper {

    Trial trialDtoToTrial(TrialDto trialDto);

    @Mapping(target = "subjects", ignore = true)
    TrialDto trialToTrialDto(Trial trial);
}
