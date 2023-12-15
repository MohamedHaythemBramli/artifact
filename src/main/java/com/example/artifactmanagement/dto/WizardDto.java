package com.example.artifactmanagement.dto;

import ch.qos.logback.classic.pattern.LineSeparatorConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WizardDto {

    private Long id;
    private String name;
}
