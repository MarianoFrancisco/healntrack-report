package com.sa.healntrack.report_service.medicine.application.port.in.update_medicine;

import java.util.UUID;

public record UpdateMedicineCommand(

        UUID id,
        String name

) { }
