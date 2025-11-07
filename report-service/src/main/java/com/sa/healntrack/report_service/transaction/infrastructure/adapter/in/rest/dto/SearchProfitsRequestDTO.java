package com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.rest.dto;

import java.time.LocalDate;
import java.util.UUID;

public record SearchProfitsRequestDTO(

        UUID area,
        LocalDate startDate,
        LocalDate endDate

) { }
