package com.sa.healntrack.report_service.patient.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.report_service.patient.domain.Patient;
import com.sa.healntrack.report_service.patient.infrastructure.adapter.out.persistence.entity.PatientEntity;

@Mapper(componentModel = "spring")
public interface PatientPersistenceMapper {

    Patient toDomain(PatientEntity entity);

    @Mapping(target = "id", source = "patient.id.value")
    @Mapping(target = "cui", source = "patient.cui.value")
    @Mapping(target = "fullName", source = "patient.fullName.value")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    PatientEntity toEntity(Patient patient);

}