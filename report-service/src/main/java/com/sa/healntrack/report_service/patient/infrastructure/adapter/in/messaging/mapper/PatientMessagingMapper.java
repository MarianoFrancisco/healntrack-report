package com.sa.healntrack.report_service.patient.infrastructure.adapter.in.messaging.mapper;

import org.mapstruct.Mapper;

import com.sa.healntrack.report_service.patient.application.port.in.create_patient.CreatePatientCommand;
import com.sa.healntrack.report_service.patient.application.port.in.update_patient.UpdatePatientCommand;
import com.sa.healntrack.report_service.patient.infrastructure.adapter.in.messaging.message.PatientCreatedMessage;
import com.sa.healntrack.report_service.patient.infrastructure.adapter.in.messaging.message.PatientUpdatedMessage;

@Mapper(componentModel = "spring")
public interface PatientMessagingMapper {

    CreatePatientCommand toCommand(PatientCreatedMessage message);

    UpdatePatientCommand toCommand(PatientUpdatedMessage message);
    
}
