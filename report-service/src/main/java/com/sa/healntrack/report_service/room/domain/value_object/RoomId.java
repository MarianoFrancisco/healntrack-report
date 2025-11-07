package com.sa.healntrack.report_service.room.domain.value_object;

import java.util.UUID;

public record RoomId(UUID value) {
    
    public RoomId {
        if (value == null) {
            throw new IllegalArgumentException("El id de la habitacion no puede ser nulo");
        }
    }

}
