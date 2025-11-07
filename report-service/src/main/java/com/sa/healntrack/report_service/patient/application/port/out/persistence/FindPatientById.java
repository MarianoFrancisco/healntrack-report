package com.sa.healntrack.report_service.patient.application.port.out.persistence;

import java.util.Optional;
import java.util.UUID;

import com.sa.healntrack.report_service.patient.domain.Patient;

public interface FindPatientById {

    Optional<Patient> findById(UUID id);
    
}
