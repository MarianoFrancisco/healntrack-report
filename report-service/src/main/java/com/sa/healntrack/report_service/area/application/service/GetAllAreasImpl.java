package com.sa.healntrack.report_service.area.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.area.application.port.in.get_all_areas.GetAllAreas;
import com.sa.healntrack.report_service.area.application.port.in.get_all_areas.GetAllAreasQuery;
import com.sa.healntrack.report_service.area.application.port.out.persistence.FindAllAreas;
import com.sa.healntrack.report_service.area.domain.Area;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class GetAllAreasImpl implements GetAllAreas {
    
    private final FindAllAreas findAllAreas;

    @Override
    public List<Area> getAll(GetAllAreasQuery query) {
        return findAllAreas.findAll(query);
    }

}
