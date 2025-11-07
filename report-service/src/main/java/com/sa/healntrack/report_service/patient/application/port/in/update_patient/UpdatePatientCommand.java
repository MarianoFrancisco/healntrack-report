package com.sa.healntrack.report_service.patient.application.port.in.update_patient;

import java.util.UUID;

public record UpdatePatientCommand(

        UUID id,
        String fullName

) { }
