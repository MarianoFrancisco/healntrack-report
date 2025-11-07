package com.sa.healntrack.report_service.employee.infrastructure.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa.healntrack.report_service.employee.infrastructure.adapter.out.persistence.entity.EmployeeEntity;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, UUID> {
    
    boolean existsByCui(String cui);

}
