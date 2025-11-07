package com.sa.healntrack.report_service.patient.infrastructure.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa.healntrack.report_service.patient.infrastructure.adapter.out.persistence.entity.PatientEntity;

public interface PatientEntityRepository extends JpaRepository<PatientEntity, UUID> {

    boolean existsByCui(String cui);
    
}
