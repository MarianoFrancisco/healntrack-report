package com.sa.healntrack.report_service.employee.application.mapper;

import org.mapstruct.Mapper;

import com.sa.healntrack.report_service.employee.application.port.in.create_employee.CreateEmployeeCommand;
import com.sa.healntrack.report_service.employee.domain.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    
    Employee toDomain(CreateEmployeeCommand command);

}
