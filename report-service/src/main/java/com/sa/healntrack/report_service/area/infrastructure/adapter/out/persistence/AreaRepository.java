package com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.area.application.port.in.get_all_areas.GetAllAreasQuery;
import com.sa.healntrack.report_service.area.application.port.out.persistence.FindAllAreas;
import com.sa.healntrack.report_service.area.application.port.out.persistence.FindAreaByName;
import com.sa.healntrack.report_service.area.domain.Area;
import com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.entity.AreaEntity;
import com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.mapper.AreaPersistenceMapper;
import com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.repository.AreaEntityRepository;
import com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.specification.AreaSpecs;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class AreaRepository implements FindAreaByName, FindAllAreas {
    
    private final AreaPersistenceMapper mapper;
    private final AreaEntityRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Area> findByName(String name) {
        return repository.findByName(name)
                .map(mapper::toDomain);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Area> findAll(GetAllAreasQuery query) {
        Specification<AreaEntity> specs = Specification.allOf(
                AreaSpecs.nameContains(query.name()));
        return repository.findAll(specs).stream()
                .map(mapper::toDomain)
                .toList();
    }

}
