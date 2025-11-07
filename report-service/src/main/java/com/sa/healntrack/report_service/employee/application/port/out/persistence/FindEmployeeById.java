package com.sa.healntrack.report_service.employee.application.port.out.persistence;

import java.util.Optional;
import java.util.UUID;

import com.sa.healntrack.report_service.employee.domain.Employee;

public interface FindEmployeeById {
    
    Optional<Employee> findById(UUID id);

}
