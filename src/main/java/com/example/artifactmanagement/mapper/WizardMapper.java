package com.example.artifactmanagement.mapper;

import com.example.artifactmanagement.dto.WizardDto;
import com.example.artifactmanagement.entities.Wizard;
import org.mapstruct.Mapper;

@Mapper
public interface WizardMapper {

    Wizard toEntity(WizardDto wizardDto);
    WizardDto toDto(Wizard wizard);
}
