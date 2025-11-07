package com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record EmployeePaymentRegisteredMessage(

        UUID employeeId,
        LocalDate payDay,
        BigDecimal totalNetAmount

) { }
