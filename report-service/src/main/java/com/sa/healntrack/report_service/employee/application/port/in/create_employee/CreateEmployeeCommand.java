package com.sa.healntrack.report_service.employee.application.port.in.create_employee;

import java.util.UUID;

public record CreateEmployeeCommand(

        UUID id,
        String cui,
        String fullName

) { }
