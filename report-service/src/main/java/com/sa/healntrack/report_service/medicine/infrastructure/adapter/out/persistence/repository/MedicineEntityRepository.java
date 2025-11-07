package com.sa.healntrack.report_service.medicine.infrastructure.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa.healntrack.report_service.medicine.infrastructure.adapter.out.persistence.entity.MedicineEntity;

public interface MedicineEntityRepository extends JpaRepository<MedicineEntity, UUID> {
    
}
