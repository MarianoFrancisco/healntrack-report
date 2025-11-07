package com.sa.healntrack.report_service.medicine.infrastructure.adapter.in.messaging.mapper;

import org.mapstruct.Mapper;

import com.sa.healntrack.report_service.medicine.application.port.in.create_medicine.CreateMedicineCommand;
import com.sa.healntrack.report_service.medicine.application.port.in.update_medicine.UpdateMedicineCommand;
import com.sa.healntrack.report_service.medicine.infrastructure.adapter.in.messaging.message.MedicineCreatedMessage;
import com.sa.healntrack.report_service.medicine.infrastructure.adapter.in.messaging.message.MedicineUpdatedMessage;

@Mapper(componentModel = "spring")
public interface MedicineMessagingMapper {

    CreateMedicineCommand toCommand(MedicineCreatedMessage message);

    UpdateMedicineCommand toCommand(MedicineUpdatedMessage message);
    
}
