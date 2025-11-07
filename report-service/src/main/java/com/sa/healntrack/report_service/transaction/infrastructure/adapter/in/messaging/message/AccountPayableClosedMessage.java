package com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record AccountPayableClosedMessage(

        UUID patientId,
        String service,
        BigDecimal fee,
        LocalDate serviceDate

) { }
