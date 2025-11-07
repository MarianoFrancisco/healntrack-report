package com.sa.healntrack.report_service.employee.infrastructure.adapter.in.messaging.mapper;

import org.mapstruct.Mapper;

import com.sa.healntrack.report_service.employee.application.port.in.create_employee.CreateEmployeeCommand;
import com.sa.healntrack.report_service.employee.application.port.in.update_employee.UpdateEmployeeCommand;
import com.sa.healntrack.report_service.employee.infrastructure.adapter.in.messaging.message.EmployeeCreatedMessage;
import com.sa.healntrack.report_service.employee.infrastructure.adapter.in.messaging.message.EmployeeUpdatedMessage;

@Mapper(componentModel = "spring")
public interface EmployeeMessagingMapper {
    
    CreateEmployeeCommand toCommand(EmployeeCreatedMessage message);

    UpdateEmployeeCommand toCommand(EmployeeUpdatedMessage message);

}
