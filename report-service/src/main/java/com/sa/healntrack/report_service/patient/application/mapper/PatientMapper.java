package com.sa.healntrack.report_service.patient.application.mapper;

import org.mapstruct.Mapper;

import com.sa.healntrack.report_service.patient.application.port.in.create_patient.CreatePatientCommand;
import com.sa.healntrack.report_service.patient.domain.Patient;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    
    Patient toDomain(CreatePatientCommand command);

}
