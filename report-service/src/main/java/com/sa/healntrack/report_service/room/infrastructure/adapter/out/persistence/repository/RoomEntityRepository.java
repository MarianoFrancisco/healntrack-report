package com.sa.healntrack.report_service.room.infrastructure.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa.healntrack.report_service.room.infrastructure.adapter.out.persistence.entity.RoomEntity;

public interface RoomEntityRepository extends JpaRepository<RoomEntity, UUID> {

    boolean existsByNumber(String number);

    boolean existsByNumberAndIdNot(String number, UUID id);
    
}
