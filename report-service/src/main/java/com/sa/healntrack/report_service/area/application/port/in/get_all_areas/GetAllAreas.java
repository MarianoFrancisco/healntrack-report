package com.sa.healntrack.report_service.area.application.port.in.get_all_areas;

import java.util.List;

import com.sa.healntrack.report_service.area.domain.Area;

public interface GetAllAreas {
    
    List<Area> getAll(GetAllAreasQuery query);

}
