package com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.rest.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Pattern;

public record SearchTransactionsRequestDTO(

        String area,
        LocalDate startDate,
        LocalDate endDate,
        @Pattern(regexp = "INCOME|EXPENSE", message = "El tipo solo puede ser INCOME o EXPENSE")
        String type

) { }
