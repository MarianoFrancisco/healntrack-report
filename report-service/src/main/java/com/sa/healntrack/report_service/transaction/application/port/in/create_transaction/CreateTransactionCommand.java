package com.sa.healntrack.report_service.transaction.application.port.in.create_transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.sa.healntrack.report_service.transaction.domain.value_object.TransactionType;

public record CreateTransactionCommand(

        String area,
        UUID referenceId,
        BigDecimal amount,
        LocalDate occurredAt,
        TransactionType type

) { }
