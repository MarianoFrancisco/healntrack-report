package com.sa.healntrack.report_service.transaction.domain.value_object;

import java.util.UUID;

public record ReferenceId(UUID value) {
    
    public ReferenceId {
        if (value == null) {
            throw new IllegalArgumentException("El id de la referencia no puede ser nulo");
        }
    }

}
