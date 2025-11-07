package com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.rest.dto;

import java.time.LocalDate;

public record SearchProfitsRequestDTO(

        String area,
        LocalDate startDate,
        LocalDate endDate

) { }
