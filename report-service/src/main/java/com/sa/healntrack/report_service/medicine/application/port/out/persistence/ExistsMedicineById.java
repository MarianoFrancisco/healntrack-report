package com.sa.healntrack.report_service.medicine.application.port.out.persistence;

import java.util.UUID;

public interface ExistsMedicineById {
    
    boolean existsById(UUID id);

}
