package com.sa.healntrack.report_service.area.domain.value_object;

import java.util.UUID;

public record AreaId(UUID value) {
    
    public AreaId {
        if (value == null) {
            throw new IllegalArgumentException("El identificador del area no puede ser nulo");
        }
    }

}
