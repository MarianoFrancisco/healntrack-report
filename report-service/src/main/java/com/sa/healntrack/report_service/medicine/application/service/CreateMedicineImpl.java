package com.sa.healntrack.report_service.medicine.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.common.application.exception.EntityAlreadyExistsException;
import com.sa.healntrack.report_service.medicine.application.mapper.MedicineMapper;
import com.sa.healntrack.report_service.medicine.application.port.in.create_medicine.CreateMedicine;
import com.sa.healntrack.report_service.medicine.application.port.in.create_medicine.CreateMedicineCommand;
import com.sa.healntrack.report_service.medicine.application.port.out.persistence.ExistsMedicineById;
import com.sa.healntrack.report_service.medicine.application.port.out.persistence.SaveMedicine;
import com.sa.healntrack.report_service.medicine.domain.Medicine;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class CreateMedicineImpl implements CreateMedicine {

    private final MedicineMapper mapper;
    private final ExistsMedicineById existsMedicineById;
    private final SaveMedicine saveMedicine;

    @Override
    public void create(CreateMedicineCommand command) {
        if (existsMedicineById.existsById(command.id())) {
            throw new EntityAlreadyExistsException(
                    "Ya existe una medicina con id: " + command.id());
        }
        Medicine medicine = mapper.toDomain(command);
        saveMedicine.save(medicine);
    }
    
}
