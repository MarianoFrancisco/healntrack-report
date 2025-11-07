package com.sa.healntrack.report_service.transaction.application.port.in.get_all_transactions;

import java.time.LocalDate;

import com.sa.healntrack.report_service.transaction.domain.value_object.TransactionType;

public record GetAllTransactionsQuery(

        LocalDate startDate,
        LocalDate endDate,
        TransactionType type,
        String area

) { }
