package com.sa.healntrack.report_service.transaction.domain.value_object;

import java.util.UUID;

public record TransactionId(UUID value) {
    
    public TransactionId {
        if (value == null) {
            throw new IllegalArgumentException("El id de la transaccion no puede ser nulo");
        }
    }

}
