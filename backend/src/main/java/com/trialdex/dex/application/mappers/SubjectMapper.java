package com.trialdex.dex.application.mappers;

import com.trialdex.dex.application.dto.SubjectDto;
import com.trialdex.dex.models.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SubjectMapper {

    Subject subjectDtoToSubject(SubjectDto subjectDto);

    @Mapping(target = "belongsTo", ignore = true)
    SubjectDto subjectToSubjectDto(Subject subject);
}
