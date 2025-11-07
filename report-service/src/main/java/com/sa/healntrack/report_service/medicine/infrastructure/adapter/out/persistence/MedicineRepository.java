package com.sa.healntrack.report_service.medicine.infrastructure.adapter.out.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.medicine.application.port.out.persistence.ExistsMedicineById;
import com.sa.healntrack.report_service.medicine.application.port.out.persistence.FindMedicineById;
import com.sa.healntrack.report_service.medicine.application.port.out.persistence.SaveMedicine;
import com.sa.healntrack.report_service.medicine.domain.Medicine;
import com.sa.healntrack.report_service.medicine.infrastructure.adapter.out.persistence.entity.MedicineEntity;
import com.sa.healntrack.report_service.medicine.infrastructure.adapter.out.persistence.mapper.MedicinePersistenceMapper;
import com.sa.healntrack.report_service.medicine.infrastructure.adapter.out.persistence.repository.MedicineEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class MedicineRepository implements SaveMedicine, ExistsMedicineById, FindMedicineById {

    private final MedicinePersistenceMapper mapper;
    private final MedicineEntityRepository repository;
    
    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Medicine save(Medicine medicine) {
        MedicineEntity entity = repository.
                save(mapper.fromDomain(medicine));
        return mapper.toDomain(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<Medicine> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

}
