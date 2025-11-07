package com.sa.healntrack.report_service.patient.application.port.in.create_patient;

import java.util.UUID;

public record CreatePatientCommand(

        UUID id,
        String cui,
        String fullName

) { }
