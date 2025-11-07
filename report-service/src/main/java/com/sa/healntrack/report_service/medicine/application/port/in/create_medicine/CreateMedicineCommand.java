package com.sa.healntrack.report_service.medicine.application.port.in.create_medicine;

import java.util.UUID;

public record CreateMedicineCommand(

        UUID id,
        String name

) { }
