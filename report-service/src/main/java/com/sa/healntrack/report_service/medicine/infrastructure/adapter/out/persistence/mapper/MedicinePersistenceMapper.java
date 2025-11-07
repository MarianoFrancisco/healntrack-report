package com.sa.healntrack.report_service.medicine.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.report_service.medicine.domain.Medicine;
import com.sa.healntrack.report_service.medicine.infrastructure.adapter.out.persistence.entity.MedicineEntity;

@Mapper(componentModel = "spring")
public interface MedicinePersistenceMapper {

    Medicine toDomain(MedicineEntity entity);

    @Mapping(target = "id", source = "medicine.id.value")
    @Mapping(target = "name", source = "medicine.name.value")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    MedicineEntity fromDomain(Medicine medicine);
    
}
