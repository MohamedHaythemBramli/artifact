package com.example.artifactmanagement.mapper;

import com.example.artifactmanagement.dto.ArtifactDto;
import com.example.artifactmanagement.entities.Artifact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper()
public interface ArtifactMapper {

    @Mapping(source = "wizardDto",target = "wizard")
    Artifact toEntity(ArtifactDto artifactDto);
    @Mapping(source = "wizard",target = "wizardDto")
    ArtifactDto toDto(Artifact artifact);

}
