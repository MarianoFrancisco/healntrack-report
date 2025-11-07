package com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.specification;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;

import com.sa.healntrack.report_service.transaction.domain.value_object.TransactionType;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.entity.TransactionEntity;

public class TransactionSpecs {

    public static Specification<TransactionEntity> hasType(TransactionType type) {
        return (root, query, criteriaBuilder) -> (type == null)
                ? null
                : criteriaBuilder.equal(root.get("type"), type);
    }

    public static Specification<TransactionEntity> hasArea(UUID areaId) {
        return (root, query, criteriaBuilder) -> (areaId == null)
                ? null
                : criteriaBuilder.equal(root.get("area").get("id"), areaId);
    }

    public static Specification<TransactionEntity> occurredBetween(
            LocalDate startDate, LocalDate endDate) {
        return (root, query, criteriaBuilder) -> {
            if (startDate == null && endDate == null) {
                return null;
            }
            if (startDate != null && endDate != null) {
                return criteriaBuilder.between(root.get("occurredAt"), startDate, endDate);
            }
            if (startDate != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("occurredAt"), startDate);
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("occurredAt"), endDate);
        };
    }
    
}
