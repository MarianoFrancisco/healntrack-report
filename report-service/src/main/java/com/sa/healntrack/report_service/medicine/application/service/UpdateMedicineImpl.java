package com.sa.healntrack.report_service.medicine.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.common.application.exception.EntityNotFoundException;
import com.sa.healntrack.report_service.medicine.application.port.in.update_medicine.UpdateMedicine;
import com.sa.healntrack.report_service.medicine.application.port.in.update_medicine.UpdateMedicineCommand;
import com.sa.healntrack.report_service.medicine.application.port.out.persistence.FindMedicineById;
import com.sa.healntrack.report_service.medicine.application.port.out.persistence.SaveMedicine;
import com.sa.healntrack.report_service.medicine.domain.Medicine;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class UpdateMedicineImpl implements UpdateMedicine {

    private final FindMedicineById findMedicineById;
    private final SaveMedicine saveMedicine;

    @Override
    public void update(UpdateMedicineCommand command) {
        Medicine medicine = findMedicineById.findById(command.id())
                .orElseThrow(() -> new EntityNotFoundException(
                        "No existe una medicina con id: " + command.id()));
        medicine.updateName(command.name());
        saveMedicine.save(medicine);
    }
    
}
