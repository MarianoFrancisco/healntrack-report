package com.sa.healntrack.report_service.employee.infrastructure.adapter.out.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.employee.application.port.out.persistence.ExistsEmployeeByCUI;
import com.sa.healntrack.report_service.employee.application.port.out.persistence.ExistsEmployeeById;
import com.sa.healntrack.report_service.employee.application.port.out.persistence.FindEmployeeById;
import com.sa.healntrack.report_service.employee.application.port.out.persistence.SaveEmployee;
import com.sa.healntrack.report_service.employee.domain.Employee;
import com.sa.healntrack.report_service.employee.infrastructure.adapter.out.persistence.entity.EmployeeEntity;
import com.sa.healntrack.report_service.employee.infrastructure.adapter.out.persistence.mapper.EmployeePersistenceMapper;
import com.sa.healntrack.report_service.employee.infrastructure.adapter.out.persistence.repository.EmployeeEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class EmployeeRepository implements FindEmployeeById, ExistsEmployeeByCUI, ExistsEmployeeById, SaveEmployee {

    private final EmployeePersistenceMapper mapper;
    private final EmployeeEntityRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Employee> findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsByCUI(String cui) {
        return repository.existsByCui(cui);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Employee save(Employee employee) {
        EmployeeEntity entity = repository
                .save(mapper.fromDomain(employee));
        return mapper.toDomain(entity);
    }
    
}
