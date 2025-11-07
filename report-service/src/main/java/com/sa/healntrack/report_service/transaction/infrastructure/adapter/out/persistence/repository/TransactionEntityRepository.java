package com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.entity.TransactionEntity;

public interface TransactionEntityRepository
        extends JpaRepository<TransactionEntity, UUID>, JpaSpecificationExecutor<TransactionEntity> {

    boolean existsByReferenceId(UUID referenceId);

}
