package com.sa.healntrack.report_service.employee.infrastructure.adapter.in.messaging.message;

import java.util.UUID;

public record EmployeeCreatedMessage(

        UUID id,
        String cui,
        String fullName

) { }
