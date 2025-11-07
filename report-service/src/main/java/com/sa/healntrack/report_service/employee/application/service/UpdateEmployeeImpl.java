package com.sa.healntrack.report_service.employee.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.common.application.exception.EntityNotFoundException;
import com.sa.healntrack.report_service.employee.application.port.in.update_employee.UpdateEmployee;
import com.sa.healntrack.report_service.employee.application.port.in.update_employee.UpdateEmployeeCommand;
import com.sa.healntrack.report_service.employee.application.port.out.persistence.FindEmployeeById;
import com.sa.healntrack.report_service.employee.application.port.out.persistence.SaveEmployee;
import com.sa.healntrack.report_service.employee.domain.Employee;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class UpdateEmployeeImpl implements UpdateEmployee {
    
    private final FindEmployeeById findEmployeeById;
    private final SaveEmployee saveEmployee;

    @Override
    public void update(UpdateEmployeeCommand command) {
        Employee employee = findEmployeeById.findById(command.id())
                .orElseThrow(() -> new EntityNotFoundException(
                    "No existe un empleado con id: " + command.id()));
        employee.updateFullName(command.fullName());
        saveEmployee.save(employee);
    }

}
