package com.example.artifactmanagement.resource;

import com.example.artifactmanagement.dto.ArtifactDto;
import com.example.artifactmanagement.entities.Artifact;
import com.example.artifactmanagement.entities.Wizard;
import com.example.artifactmanagement.service.impl.ArtifactServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ArtifactControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ArtifactServiceImpl artifactService;

    private List<ArtifactDto> artifacts;

    @BeforeEach
    void setUp() {
        this.artifacts = new ArrayList<>();
        ArtifactDto artifact1 = ArtifactDto.builder()
                .id(1L)
                .name("test")
                .description("Let's Test")
                .imageUrl("url")
                .build();
        ArtifactDto artifact2 = ArtifactDto.builder()
                .id(2L)
                .name("test2")
                .description("Let's Test2")
                .imageUrl("url2")
                .build();
        artifacts.add(artifact1);
        artifacts.add(artifact2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
    }

    @Test
    void testFindArtifactByIdSuccess() throws Exception {
        //Given
        BDDMockito.given(artifactService.findArtifactById(1L)).willReturn(artifacts.get(0));
        //When
        mockMvc.perform(get("/api/artifacts/{id}",1L).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
              .andExpect(jsonPath("$.id").value(artifacts.get(0).getId()))
                .andExpect(jsonPath("$.name").value(artifacts.get(0).getName()));
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