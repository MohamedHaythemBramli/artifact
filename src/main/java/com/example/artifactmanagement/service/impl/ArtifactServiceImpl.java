package com.example.artifactmanagement.service.impl;

import com.example.artifactmanagement.dto.ArtifactDto;
import com.example.artifactmanagement.entities.Artifact;
import com.example.artifactmanagement.mapper.ArtifactMapper;
import com.example.artifactmanagement.repositories.ArtifactRepository;
import com.example.artifactmanagement.service.ArtifactService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class ArtifactServiceImpl implements ArtifactService {

    private final ArtifactRepository artifactRepository;
    private final ArtifactMapper artifactMapper;



    @Override
    public List<ArtifactDto> findAllArtifacts() {
        return artifactRepository.findAll().stream().map(artifactMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ArtifactDto findArtifactById(Long id) {
        return artifactRepository.findById(id)
                .map(artifactMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Artifact with Id "+id+" Does not exist"));
    }

    @Override
    public ArtifactDto createArtifact(ArtifactDto artifactDto) {
        Objects.requireNonNull(artifactDto,"object must be not null");
        return artifactMapper.toDto(artifactRepository.save(artifactMapper.toEntity(artifactDto)));
    }

    @Override
    public ArtifactDto updateArtifact(ArtifactDto artifactDto) {
        return artifactMapper.toDto(artifactRepository.save(artifactMapper.toEntity(artifactDto)));
    }

    @Override
    public void deleteArtifactById(Long id) {
        Optional<Artifact> artifact = artifactRepository.findById(id);
        if (artifact.isPresent()){
            artifactRepository.deleteById(id);
        }
        else throw new EntityNotFoundException("Artifact with id "+id+" does not exit" );
    }
}
