package com.example.artifactmanagement.service;

import com.example.artifactmanagement.dto.ArtifactDto;
import com.example.artifactmanagement.dto.WizardDto;

import java.util.List;

public interface ArtifactService {
    List<ArtifactDto> findAllArtifacts();
    ArtifactDto findArtifactById(Long id);
    ArtifactDto createArtifact (ArtifactDto  artifactDto);
    ArtifactDto  updateArtifact (ArtifactDto  artifactDto);
    void deleteArtifactById(Long id);
}
