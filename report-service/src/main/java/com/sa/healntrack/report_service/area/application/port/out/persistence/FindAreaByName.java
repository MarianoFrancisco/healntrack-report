package com.sa.healntrack.report_service.area.application.port.out.persistence;

import java.util.Optional;

import com.sa.healntrack.report_service.area.domain.Area;

public interface FindAreaByName {
    
    Optional<Area> findByName(String name);

}
