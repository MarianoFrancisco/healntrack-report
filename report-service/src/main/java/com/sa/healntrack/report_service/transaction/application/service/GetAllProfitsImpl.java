package com.sa.healntrack.report_service.transaction.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.area.domain.value_object.EntityReference;
import com.sa.healntrack.report_service.employee.application.port.out.persistence.FindEmployeeById;
import com.sa.healntrack.report_service.medicine.application.port.out.persistence.FindMedicineById;
import com.sa.healntrack.report_service.patient.application.port.out.persistence.FindPatientById;
import com.sa.healntrack.report_service.room.application.port.out.persistence.FindRoomById;
import com.sa.healntrack.report_service.transaction.application.port.in.get_all_profits.GetAllProfits;
import com.sa.healntrack.report_service.transaction.application.port.in.get_all_profits.GetAllProfitsQuery;
import com.sa.healntrack.report_service.transaction.application.port.out.persistence.FindAllProfits;
import com.sa.healntrack.report_service.transaction.domain.TransactionProfit;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class GetAllProfitsImpl implements GetAllProfits {
    
    private FindAllProfits findAllProfits;
    private final FindPatientById findPatientById;
    private final FindMedicineById findMedicineById;
    private final FindEmployeeById findEmployeeById;
    private final FindRoomById findRoomById;

    @Override
    public List<TransactionProfit> getAll(GetAllProfitsQuery query) {
        List<TransactionProfit> transactions = findAllProfits.findAll(query);
        for (TransactionProfit transaction : transactions) {
            String concept = getConcept(
                    transaction.getArea().getEntityReference(),
                    transaction.getReferenceId().value());
            transaction.defineConcept(concept);
        }
        return transactions;
    }

    private String getConcept(EntityReference entityReference, UUID referenceId) {
        try {
            return switch (entityReference) {
                case EMPLOYEE -> findEmployeeById.findById(referenceId)
                        .map(e -> e.getFullName().value())
                        .orElse("Empleado desconocido");
                case MEDICINE -> findMedicineById.findById(referenceId)
                        .map(m -> m.getName().value())
                        .orElse("Medicina desconocida");
                case ROOM -> findRoomById.findById(referenceId)
                        .map(r -> r.getNumber().value())
                        .orElse("Habitación desconocida");
                case PATIENT -> findPatientById.findById(referenceId)
                        .map(p -> p.getFullName().value())
                        .orElse("Paciente desconocido");
            };
        } catch (Exception e) {
            return "Desconocido";
        }
    }

}
