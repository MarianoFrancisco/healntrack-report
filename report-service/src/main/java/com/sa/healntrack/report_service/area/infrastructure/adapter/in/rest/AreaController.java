package com.sa.healntrack.report_service.area.infrastructure.adapter.in.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.healntrack.report_service.area.application.port.in.get_all_areas.GetAllAreas;
import com.sa.healntrack.report_service.area.infrastructure.adapter.in.rest.dto.AreaResponseDTO;
import com.sa.healntrack.report_service.area.infrastructure.adapter.in.rest.dto.SearchAreasRequestDTO;
import com.sa.healntrack.report_service.area.infrastructure.adapter.in.rest.mapper.AreaRestMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/areas")
@RestController
public class AreaController {

    private final AreaRestMapper mapper;
    private final GetAllAreas getAllAreas;

    @GetMapping
    public ResponseEntity<List<AreaResponseDTO>> getAll(
            SearchAreasRequestDTO requestDTO) {
        List<AreaResponseDTO> areas = getAllAreas.getAll(mapper.toQuery(requestDTO))
                .stream()
                .map(mapper::fromDomain)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(areas);
    }
    
}
