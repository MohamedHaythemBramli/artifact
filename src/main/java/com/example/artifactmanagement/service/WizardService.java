package com.example.artifactmanagement.service;

import com.example.artifactmanagement.dto.WizardDto;
import com.example.artifactmanagement.entities.Wizard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WizardService {
    List<WizardDto> findAllWizards();
    WizardDto findWizardById(Long id);
    WizardDto createWizard(WizardDto wizardDto);
    WizardDto updateWizardDto(WizardDto wizardDto);
    void deleteWizardById(Long id);
}
