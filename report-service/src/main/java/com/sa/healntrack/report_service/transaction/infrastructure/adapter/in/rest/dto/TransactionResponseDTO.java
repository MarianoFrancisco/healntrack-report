package com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record TransactionResponseDTO(

        UUID id,
        String area,
        String concept,
        LocalDate occurredAt,
        BigDecimal amount

) { }
