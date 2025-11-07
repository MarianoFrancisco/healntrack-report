package com.sa.healntrack.report_service.medicine.infrastructure.adapter.in.messaging.message;

import java.util.UUID;

public record MedicineCreatedMessage(

        UUID id,
        String name

) { }
