package com.sa.healntrack.report_service.transaction.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.area.application.port.out.persistence.FindAreaByName;
import com.sa.healntrack.report_service.area.domain.Area;
import com.sa.healntrack.report_service.common.application.exception.EntityNotFoundException;
import com.sa.healntrack.report_service.transaction.application.mapper.TransactionMapper;
import com.sa.healntrack.report_service.transaction.application.port.in.create_transaction.CreateTransaction;
import com.sa.healntrack.report_service.transaction.application.port.in.create_transaction.CreateTransactionCommand;
import com.sa.healntrack.report_service.transaction.application.port.out.persistence.SaveTransaction;
import com.sa.healntrack.report_service.transaction.domain.Transaction;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class CreateTransactionImpl implements CreateTransaction {
    
    private final TransactionMapper mapper;
    private final FindAreaByName findAreaByName;
    private final SaveTransaction saveTransaction;

    @Override
    public void create(CreateTransactionCommand command) {
        Area area = findAreaByName.findByName(command.area())
                .orElseThrow(() -> new EntityNotFoundException(
                            "No existe un area con nombre: " + command.area()));
        Transaction transaction = mapper.toDomain(command, area);
        saveTransaction.save(transaction);
    }

}
