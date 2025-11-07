package com.sa.healntrack.report_service.room.application.port.out.persistence;

import com.sa.healntrack.report_service.room.domain.Room;

public interface SaveRoom {
    
    Room save(Room room);

}
