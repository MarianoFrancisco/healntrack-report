package com.sa.healntrack.report_service.transaction.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.area.domain.value_object.EntityReference;
import com.sa.healntrack.report_service.common.application.exception.EntityNotFoundException;
import com.sa.healntrack.report_service.employee.application.port.out.persistence.FindEmployeeById;
import com.sa.healntrack.report_service.employee.domain.Employee;
import com.sa.healntrack.report_service.medicine.application.port.out.persistence.FindMedicineById;
import com.sa.healntrack.report_service.medicine.domain.Medicine;
import com.sa.healntrack.report_service.patient.application.port.out.persistence.FindPatientById;
import com.sa.healntrack.report_service.patient.domain.Patient;
import com.sa.healntrack.report_service.room.application.port.out.persistence.FindRoomById;
import com.sa.healntrack.report_service.room.domain.Room;
import com.sa.healntrack.report_service.transaction.application.port.in.get_all_transactions.GetAllTransactions;
import com.sa.healntrack.report_service.transaction.application.port.in.get_all_transactions.GetAllTransactionsQuery;
import com.sa.healntrack.report_service.transaction.application.port.out.persistence.FindAllTransactions;
import com.sa.healntrack.report_service.transaction.domain.Transaction;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class GetAllTransactionsImpl implements GetAllTransactions {

    private final FindAllTransactions findAllTransactions;
    private final FindPatientById findPatientById;
    private final FindMedicineById findMedicineById;
    private final FindEmployeeById findEmployeeById;
    private final FindRoomById findRoomById;

    @Override
    public List<Transaction> getAll(GetAllTransactionsQuery query) {
        List<Transaction> transactions = findAllTransactions.findAll(query);
        for (Transaction transaction : transactions) {
            String concept = getConcept(
                    transaction.getArea().getEntityReference(),
                    transaction.getReferenceId().value());
            transaction.defineConcept(concept);
        }
        return transactions;
    }

    private String getConcept(EntityReference entityReference, UUID referenceId) {
        switch (entityReference) {
            case EMPLOYEE:
                Employee employee = findEmployeeById.findById(referenceId)
                        .orElseThrow(() -> new EntityNotFoundException(
                                "No existe un empleado con id: " + referenceId));
                return employee.getFullName().value();
            case MEDICINE:
                Medicine medicine = findMedicineById.findById(referenceId)
                        .orElseThrow(() -> new EntityNotFoundException(
                                "No existe una medicina con id: " + referenceId));
                return medicine.getName().value();
            case ROOM:
                Room room = findRoomById.findById(referenceId)
                        .orElseThrow(() -> new EntityNotFoundException(
                                "No existe una habitacion con id: " + referenceId));
                return room.getNumber().value();
            default:
                Patient patient = findPatientById.findById(referenceId)
                        .orElseThrow(() -> new EntityNotFoundException(
                                "No existe un empleado con id: " + referenceId));
                return patient.getFullName().value();
        }
    }

}
