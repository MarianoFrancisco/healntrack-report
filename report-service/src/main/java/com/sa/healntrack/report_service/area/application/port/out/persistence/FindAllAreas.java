package com.sa.healntrack.report_service.area.application.port.out.persistence;

import java.util.List;

import com.sa.healntrack.report_service.area.application.port.in.get_all_areas.GetAllAreasQuery;
import com.sa.healntrack.report_service.area.domain.Area;

public interface FindAllAreas {
    
    List<Area> findAll(GetAllAreasQuery query);

}
