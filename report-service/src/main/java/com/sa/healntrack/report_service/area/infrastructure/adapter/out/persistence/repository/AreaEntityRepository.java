package com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.entity.AreaEntity;

public interface AreaEntityRepository extends JpaRepository<AreaEntity, UUID>, JpaSpecificationExecutor<AreaEntity> {

    Optional<AreaEntity> findByName(String name);

}
