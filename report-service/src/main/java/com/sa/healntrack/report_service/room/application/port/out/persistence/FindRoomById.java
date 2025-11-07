package com.sa.healntrack.report_service.room.application.port.out.persistence;

import java.util.Optional;
import java.util.UUID;

import com.sa.healntrack.report_service.room.domain.Room;

public interface FindRoomById {
    
    Optional<Room> findById(UUID id);

}
