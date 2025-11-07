package com.sa.healntrack.report_service.medicine.application.port.out.persistence;

import com.sa.healntrack.report_service.medicine.domain.Medicine;

public interface SaveMedicine {
    
    Medicine save(Medicine medicine);

}
