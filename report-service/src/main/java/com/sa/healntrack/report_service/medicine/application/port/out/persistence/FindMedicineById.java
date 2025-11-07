package com.sa.healntrack.report_service.medicine.application.port.out.persistence;

import java.util.Optional;
import java.util.UUID;

import com.sa.healntrack.report_service.medicine.domain.Medicine;

public interface FindMedicineById {

    Optional<Medicine> findById(UUID id);
    
}
