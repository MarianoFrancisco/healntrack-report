package com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.entity.AreaEntity;

public interface AreaEntityRepository extends JpaRepository<AreaEntity, UUID> {

}
