package com.sa.healntrack.report_service.patient.infrastructure.adapter.in.messaging.message;

import java.util.UUID;

public record PatientCreatedMessage(

        UUID id,
        String cui,
        String fullName

) { }
