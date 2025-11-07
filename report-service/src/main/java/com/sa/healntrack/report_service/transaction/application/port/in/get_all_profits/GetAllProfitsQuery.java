package com.sa.healntrack.report_service.transaction.application.port.in.get_all_profits;

import java.time.LocalDate;
import java.util.UUID;

public record GetAllProfitsQuery(

        LocalDate startDate,
        LocalDate endDate,
        UUID area

) { }
