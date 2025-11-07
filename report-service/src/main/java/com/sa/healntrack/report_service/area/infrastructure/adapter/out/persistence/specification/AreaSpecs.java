package com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.entity.AreaEntity;

public class AreaSpecs {
    
    public static Specification<AreaEntity> nameContains(String name) {
        return (root, query, criteriaBuilder) -> (name == null || name.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(
                                root.get("name")),
                                "%" + name.toLowerCase() + "%");
    }

}
