package com.sa.healntrack.report_service.patient.infrastructure.adapter.out.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.patient.application.port.out.persistence.ExistsPatientByCUI;
import com.sa.healntrack.report_service.patient.application.port.out.persistence.ExistsPatientById;
import com.sa.healntrack.report_service.patient.application.port.out.persistence.FindPatientById;
import com.sa.healntrack.report_service.patient.application.port.out.persistence.SavePatient;
import com.sa.healntrack.report_service.patient.domain.Patient;
import com.sa.healntrack.report_service.patient.infrastructure.adapter.out.persistence.entity.PatientEntity;
import com.sa.healntrack.report_service.patient.infrastructure.adapter.out.persistence.mapper.PatientPersistenceMapper;
import com.sa.healntrack.report_service.patient.infrastructure.adapter.out.persistence.repository.PatientEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PatientRepository implements SavePatient, FindPatientById, ExistsPatientByCUI, ExistsPatientById {

    private final PatientEntityRepository repository;
    private final PatientPersistenceMapper mapper;

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Patient save(Patient patient) {
        PatientEntity entity = repository.save(mapper.toEntity(patient));
        return mapper.toDomain(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Patient> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsByCUI(String cui) {
        return repository.existsByCui(cui);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }
    
}
