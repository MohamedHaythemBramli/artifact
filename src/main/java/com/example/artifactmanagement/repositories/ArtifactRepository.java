package com.example.artifactmanagement.repositories;

import com.example.artifactmanagement.entities.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
}