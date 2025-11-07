package com.sa.healntrack.report_service.patient.application.port.out.persistence;

import java.util.UUID;

public interface ExistsPatientById {
    
    boolean existsById(UUID id);

}
