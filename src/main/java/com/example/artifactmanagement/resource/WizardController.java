package com.example.artifactmanagement.resource;

import com.example.artifactmanagement.dto.WizardDto;
import com.example.artifactmanagement.service.WizardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wizards")
public class WizardController {
    private final WizardService wizardService;
    @GetMapping
    public ResponseEntity<List<WizardDto>> findAll(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(wizardService.findAllWizards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WizardDto> findWizardById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(wizardService.findWizardById(id));
    }

    @PostMapping
    public ResponseEntity<WizardDto> createWizard(@RequestBody WizardDto wizardDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(wizardService.createWizard(wizardDto));
    }

    @PutMapping
    public ResponseEntity<WizardDto> updateWizard(@RequestBody WizardDto wizardDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(wizardService.updateWizardDto(wizardDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteWizardById(@PathVariable Long id){
        wizardService.deleteWizardById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
