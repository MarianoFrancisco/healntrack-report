package com.sa.healntrack.report_service.patient.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.common.application.exception.EntityNotFoundException;
import com.sa.healntrack.report_service.patient.application.port.in.update_patient.UpdatePatient;
import com.sa.healntrack.report_service.patient.application.port.in.update_patient.UpdatePatientCommand;
import com.sa.healntrack.report_service.patient.application.port.out.persistence.FindPatientById;
import com.sa.healntrack.report_service.patient.application.port.out.persistence.SavePatient;
import com.sa.healntrack.report_service.patient.domain.Patient;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class UpdatePatientImpl implements UpdatePatient {

    private final FindPatientById findPatientById;
    private final SavePatient savePatient;
    
    @Override
    public void update(UpdatePatientCommand command) {
        Patient patient = findPatientById.findById(command.id())
                .orElseThrow(() -> new EntityNotFoundException(
                        "No existe un paciente con el id: " + command.id()));
        patient.updateFullName(command.fullName());
        savePatient.save(patient);
    }


}
