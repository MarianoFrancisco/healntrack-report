package com.sa.healntrack.report_service.patient.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.common.application.exception.EntityAlreadyExistsException;
import com.sa.healntrack.report_service.patient.application.mapper.PatientMapper;
import com.sa.healntrack.report_service.patient.application.port.in.create_patient.CreatePatient;
import com.sa.healntrack.report_service.patient.application.port.in.create_patient.CreatePatientCommand;
import com.sa.healntrack.report_service.patient.application.port.out.persistence.ExistsPatientByCUI;
import com.sa.healntrack.report_service.patient.application.port.out.persistence.ExistsPatientById;
import com.sa.healntrack.report_service.patient.application.port.out.persistence.SavePatient;
import com.sa.healntrack.report_service.patient.domain.Patient;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class CreatePatientImpl implements CreatePatient {

    private final PatientMapper mapper;
    private final ExistsPatientById existsPatientById;
    private final ExistsPatientByCUI existsPatientByCUI;
    private final SavePatient savePatient;

    @Override
    public void create(CreatePatientCommand command) {
        if (existsPatientById.existsById(command.id())) {
            throw new EntityAlreadyExistsException(
                    "Ya existe un paciente registrado con id: " + command.id());
        }
        Patient patient = mapper.toDomain(command);
        String cui = patient.getCui().value();
        if (existsPatientByCUI.existsByCUI(cui)) {
            throw new EntityAlreadyExistsException(
                    "Ya existe un paciente registrado con el CUI: " + cui);
        }
        savePatient.save(patient);
    }
    
}
