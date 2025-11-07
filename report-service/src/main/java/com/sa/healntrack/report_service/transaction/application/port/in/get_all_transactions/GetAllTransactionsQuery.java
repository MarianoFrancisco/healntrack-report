package com.sa.healntrack.report_service.transaction.application.port.in.get_all_transactions;

import java.time.LocalDate;
import java.util.UUID;

import com.sa.healntrack.report_service.transaction.domain.value_object.TransactionType;

public record GetAllTransactionsQuery(

        LocalDate startDate,
        LocalDate endDate,
        TransactionType type,
        UUID area

) { }
