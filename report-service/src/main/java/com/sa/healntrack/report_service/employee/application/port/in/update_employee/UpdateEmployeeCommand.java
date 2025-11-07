package com.sa.healntrack.report_service.employee.application.port.in.update_employee;

import java.util.UUID;

public record UpdateEmployeeCommand(

        UUID id,
        String fullName

) { }
