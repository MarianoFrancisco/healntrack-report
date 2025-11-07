package com.sa.healntrack.report_service.transaction.application.port.in.get_all_profits;

import java.time.LocalDate;

public record GetAllProfitsQuery(

        LocalDate startDate,
        LocalDate endDate,
        String area

) { }
