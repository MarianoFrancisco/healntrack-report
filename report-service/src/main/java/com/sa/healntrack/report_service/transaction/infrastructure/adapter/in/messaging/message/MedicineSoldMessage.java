package com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.sa.healntrack.report_service.transaction.domain.value_object.TransactionType;

public record MedicineSoldMessage(

        UUID medicineId,
        String service,
        LocalDate occurredAt,
        TransactionType type,
        BigDecimal lineTotal

) { }
