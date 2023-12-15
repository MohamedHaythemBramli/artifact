package com.example.artifactmanagement.service.impl;

import com.example.artifactmanagement.dto.WizardDto;
import com.example.artifactmanagement.mapper.WizardMapper;
import com.example.artifactmanagement.repositories.WizardRepository;
import com.example.artifactmanagement.service.WizardService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class WizardServiceImpl implements WizardService {

    private final WizardRepository wizardRepository;
    private final WizardMapper wizardMapper;


    @Override
    public List<WizardDto> findAllWizards() {
        return wizardRepository.findAll().stream().map(wizardMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public WizardDto findWizardById(Long id) {
        return wizardRepository.findById(id).map(wizardMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Wizard Does not exists"));
    }

    @Override
    public WizardDto createWizard(WizardDto wizardDto) {
        return wizardMapper.toDto(wizardRepository.save(wizardMapper.toEntity(wizardDto)));
    }

    @Override
    public WizardDto updateWizardDto(WizardDto wizardDto) {
        return wizardMapper.toDto(wizardRepository.save(wizardMapper.toEntity(wizardDto)));
    }

    @Override
    public void deleteWizardById(Long id) {
        wizardRepository.deleteById(id);
    }
}
