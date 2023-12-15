package com.example.artifactmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wizards")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Wizard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "wizard",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Artifact> artifacts = new ArrayList<>();

    public void addArtifact(Artifact artifact){
        this.artifacts.add(artifact);
        artifact.setWizard(this);
    }
    public void removeArtifact(Artifact artifact){
        this.artifacts.remove(artifact);
        artifact.setWizard(null);
    }
}
