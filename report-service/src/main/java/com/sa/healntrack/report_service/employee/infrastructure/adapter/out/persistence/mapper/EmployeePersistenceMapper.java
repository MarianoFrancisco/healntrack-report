package com.sa.healntrack.report_service.employee.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.report_service.employee.domain.Employee;
import com.sa.healntrack.report_service.employee.infrastructure.adapter.out.persistence.entity.EmployeeEntity;

@Mapper(componentModel = "spring")
public interface EmployeePersistenceMapper {
    
    Employee toDomain(EmployeeEntity employeeEntity);

    @Mapping(target = "id", source = "employee.id.value")
    @Mapping(target = "cui", source = "employee.cui.value")
    @Mapping(target = "fullName", source = "employee.fullName.value")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    EmployeeEntity fromDomain(Employee employee);

}
