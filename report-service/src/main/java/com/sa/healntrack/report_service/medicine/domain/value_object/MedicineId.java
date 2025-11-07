package com.sa.healntrack.report_service.medicine.domain.value_object;

import java.util.UUID;

public record MedicineId(UUID value) {
    public MedicineId {
        if (value == null) {
            throw new IllegalArgumentException("El identificador de la medicina no puede ser nulo");
        }
    }
}