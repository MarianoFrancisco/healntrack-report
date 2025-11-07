package com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa.healntrack.report_service.transaction.domain.TransactionProfit;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.entity.TransactionEntity;

public interface TransactionEntityRepository
        extends JpaRepository<TransactionEntity, UUID>, JpaSpecificationExecutor<TransactionEntity> {

    boolean existsByReferenceId(UUID referenceId);

    @Query("""
            SELECT new com.sa.healntrack.report_service.transaction.domain.TransactionProfit(
                t.referenceId,
                new com.sa.healntrack.report_service.area.domain.Area(a.id, a.name, a.entityReference),
                SUM(CASE WHEN t.type = 'INCOME' THEN t.amount ELSE -t.amount END),
                t.occurredAt
            )
            FROM TransactionEntity t
            JOIN t.area a
            WHERE (:areaId IS NULL OR a.id = :areaId)
              AND (:startDate IS NULL OR t.occurredAt >= CAST(:startDate AS date))
              AND (:endDate IS NULL OR t.occurredAt <= CAST(:endDate AS date))
            GROUP BY t.referenceId, t.occurredAt, a.id, a.name, a.entityReference
            """)
    List<TransactionProfit> findProfitsFiltered(
            @Param("areaId") UUID areaId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

}
