package com.sa.healntrack.report_service.employee.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.common.application.exception.EntityAlreadyExistsException;
import com.sa.healntrack.report_service.employee.application.mapper.EmployeeMapper;
import com.sa.healntrack.report_service.employee.application.port.in.create_employee.CreateEmployee;
import com.sa.healntrack.report_service.employee.application.port.in.create_employee.CreateEmployeeCommand;
import com.sa.healntrack.report_service.employee.application.port.out.persistence.ExistsEmployeeByCUI;
import com.sa.healntrack.report_service.employee.application.port.out.persistence.ExistsEmployeeById;
import com.sa.healntrack.report_service.employee.application.port.out.persistence.SaveEmployee;
import com.sa.healntrack.report_service.employee.domain.Employee;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class CreateEmployeeImpl implements CreateEmployee {
    
    private final EmployeeMapper mapper;
    private final ExistsEmployeeById existsEmployeeById;
    private final ExistsEmployeeByCUI existsEmployeeByCUI;
    private final SaveEmployee saveEmployee;

    @Override
    public void create(CreateEmployeeCommand command) {
        if (existsEmployeeById.existsById(command.id())) {
            throw new EntityAlreadyExistsException(
                    "Ya existe un empleado con el id: " + command.id());
        }
        if (existsEmployeeByCUI.existsByCUI(command.cui())) {
            throw new EntityAlreadyExistsException(
                    "Ya existe un empleado con el cui: " + command.cui());
        }
        Employee employee = mapper.toDomain(command);
        saveEmployee.save(employee);
    }

}
