package com.sa.healntrack.report_service.room.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.report_service.room.domain.Room;
import com.sa.healntrack.report_service.room.infrastructure.adapter.out.persistence.entity.RoomEntity;

@Mapper(componentModel = "spring")
public interface RoomPersistenceMapper {
    
    Room toDomain(RoomEntity roomEntity);

    @Mapping(target = "id", source = "room.id.value")
    @Mapping(target = "number", source = "room.number.value")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RoomEntity fromDomain(Room room);

}
