package com.sa.healntrack.report_service.patient.infrastructure.adapter.in.messaging.message;

import java.util.UUID;

public record PatientUpdatedMessage(

        UUID id,
        String fullName

) { }
