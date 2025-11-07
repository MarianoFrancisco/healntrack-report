package com.sa.healntrack.report_service.patient.application.port.out.persistence;

public interface ExistsPatientByCUI {
    
    boolean existsByCUI(String cui);

}
