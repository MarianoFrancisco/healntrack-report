package com.sa.healntrack.report_service.medicine.application.mapper;

import org.mapstruct.Mapper;

import com.sa.healntrack.report_service.medicine.application.port.in.create_medicine.CreateMedicineCommand;
import com.sa.healntrack.report_service.medicine.domain.Medicine;

@Mapper(componentModel = "spring")
public interface MedicineMapper {
    
    Medicine toDomain(CreateMedicineCommand command);

}
