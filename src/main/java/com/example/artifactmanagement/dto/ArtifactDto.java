package com.example.artifactmanagement.dto;

import com.example.artifactmanagement.entities.Wizard;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArtifactDto {
    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    @JsonProperty(value = "wizard")
    private WizardDto wizardDto;
}
