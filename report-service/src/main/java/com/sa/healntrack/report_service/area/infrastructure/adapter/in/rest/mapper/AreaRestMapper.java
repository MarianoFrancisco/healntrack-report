package com.sa.healntrack.report_service.area.infrastructure.adapter.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.report_service.area.application.port.in.get_all_areas.GetAllAreasQuery;
import com.sa.healntrack.report_service.area.domain.Area;
import com.sa.healntrack.report_service.area.infrastructure.adapter.in.rest.dto.AreaResponseDTO;
import com.sa.healntrack.report_service.area.infrastructure.adapter.in.rest.dto.SearchAreasRequestDTO;

@Mapper(componentModel = "spring")
public interface AreaRestMapper {

    @Mapping(target = "id", source = "area.id.value")
    @Mapping(target = "name", source = "area.name.value")
    AreaResponseDTO fromDomain(Area area);
    
    GetAllAreasQuery toQuery(SearchAreasRequestDTO requestDTO);

}
