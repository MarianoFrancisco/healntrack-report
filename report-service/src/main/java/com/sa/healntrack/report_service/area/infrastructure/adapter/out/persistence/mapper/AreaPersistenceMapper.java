package com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.report_service.area.domain.Area;
import com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.entity.AreaEntity;

@Mapper(componentModel = "spring")
public interface AreaPersistenceMapper {
    
    Area toDomain(AreaEntity entity);

    @Mapping(target = "id", source = "area.id.value")
    @Mapping(target = "name", source = "area.name.value")
    AreaEntity fromDomain(Area area);

}
