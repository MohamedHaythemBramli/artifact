package com.example.artifactmanagement.resource;

import com.example.artifactmanagement.dto.ArtifactDto;
import com.example.artifactmanagement.service.ArtifactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artifacts")
@RequiredArgsConstructor
public class ArtifactController {

    private final ArtifactService artifactService;

    @GetMapping
    public ResponseEntity<List<ArtifactDto>> findAll(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(artifactService.findAllArtifacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtifactDto> findArtifactById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(artifactService.findArtifactById(id));
    }

    @PostMapping
    public ResponseEntity<ArtifactDto> createArtifact(@RequestBody ArtifactDto artifactDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(artifactService.createArtifact(artifactDto));
    }

    @PutMapping
    public ResponseEntity<ArtifactDto> updateArtifact(@RequestBody ArtifactDto artifactDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(artifactService.updateArtifact(artifactDto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteArtifactById(@PathVariable Long id){
        artifactService.deleteArtifactById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
