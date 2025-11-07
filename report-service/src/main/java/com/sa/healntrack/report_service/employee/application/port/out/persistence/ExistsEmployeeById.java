package com.sa.healntrack.report_service.employee.application.port.out.persistence;

import java.util.UUID;

public interface ExistsEmployeeById {
    
    boolean existsById(UUID id);

}
