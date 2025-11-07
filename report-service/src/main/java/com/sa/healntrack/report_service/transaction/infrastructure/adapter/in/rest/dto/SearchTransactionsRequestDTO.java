package com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.rest.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Pattern;

public record SearchTransactionsRequestDTO(

        UUID area,
        LocalDate startDate,
        LocalDate endDate,
        @Pattern(regexp = "INCOME|EXPENSE", message = "El tipo solo puede ser INCOME o EXPENSE")
        String type

) { }
