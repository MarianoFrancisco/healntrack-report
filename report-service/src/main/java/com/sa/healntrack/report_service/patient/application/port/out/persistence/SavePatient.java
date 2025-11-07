package com.sa.healntrack.report_service.patient.application.port.out.persistence;

import com.sa.healntrack.report_service.patient.domain.Patient;

public interface SavePatient {
    
    Patient save(Patient patient);

}
