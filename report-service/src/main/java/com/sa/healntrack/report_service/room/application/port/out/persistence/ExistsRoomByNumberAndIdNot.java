package com.sa.healntrack.report_service.room.application.port.out.persistence;

import java.util.UUID;

public interface ExistsRoomByNumberAndIdNot {
    
    boolean existsByNumberAndIdNot(String number, UUID id);

}
