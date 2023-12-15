package com.example.artifactmanagement.service.impl;

import com.example.artifactmanagement.dto.ArtifactDto;
import com.example.artifactmanagement.dto.WizardDto;
import com.example.artifactmanagement.entities.Artifact;
import com.example.artifactmanagement.entities.Wizard;
import com.example.artifactmanagement.mapper.ArtifactMapper;
import com.example.artifactmanagement.mapper.ArtifactMapperImpl;
import com.example.artifactmanagement.repositories.ArtifactRepository;
import com.example.artifactmanagement.service.ArtifactService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ArtifactServiceImplTest {
    @Mock
    private ArtifactRepository artifactRepository;
    @Mock
    private ArtifactServiceImpl artifactService;
    @Mock
    private ArtifactMapperImpl artifactMapper;

    private ArtifactDto returnedArtifact;
    @BeforeEach
    void setUp() {
        artifactService = new ArtifactServiceImpl(artifactRepository,artifactMapper);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAllArtifacts() {
        //given
        Artifact artifact1 = Artifact.builder()
                .id(1L)
                .name("test")
                .description("Let's Test")
                .imageUrl("url")
                .wizard(Wizard.builder().id(1L).name(null).artifacts(null).build())
                .build();
        Artifact artifact2 = Artifact.builder()
                .id(2L)
                .name("test2")
                .description("Let's Test2")
                .imageUrl("url2")
                .wizard(Wizard.builder().id(2L).name(null).artifacts(null).build())
                .build();
        List<Artifact> artifacts = List.of(artifact1,artifact2);
        BDDMockito.given(artifactRepository.findAll()).willReturn(artifacts);
        //when
        List<ArtifactDto> artifactDtos = artifacts.stream().map(artifactMapper::toDto).collect(Collectors.toList());
        List<ArtifactDto> artifactsDtoFromService = artifactService.findAllArtifacts();
        Assertions.assertThat(artifactDtos).isEqualTo(artifactsDtoFromService);
    }

    @Test
    void findArtifactById() {
        //given
        Artifact artifact = Artifact.builder()
                .id(1L)
                .name("test")
                .description("Let's Test")
                .imageUrl("url")
                .wizard(Wizard.builder().id(1L).name(null).artifacts(null).build())
                .build();
        BDDMockito.given(artifactRepository.findById(1L)).willReturn(Optional.of(artifact));
        //when
        ArtifactDto artifactDto = artifactMapper.toDto(artifact);
        System.out.println(artifactDto);
        returnedArtifact = artifactService.findArtifactById(1L);
        System.out.println(returnedArtifact);
        //then
        Assertions.assertThat(returnedArtifact.getId()).isEqualTo(artifactDto.getId());
        Mockito.verify(artifactRepository,Mockito.times(1)).findById(1L);
    }

    @Test
    void createArtifact() {
    }

    @Test
    void updateArtifact() {
    }

    @Test
    void deleteArtifactById() {
    }
}