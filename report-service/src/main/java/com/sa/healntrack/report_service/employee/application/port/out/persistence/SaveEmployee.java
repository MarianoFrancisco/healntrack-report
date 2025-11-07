package com.sa.healntrack.report_service.employee.application.port.out.persistence;

import com.sa.healntrack.report_service.employee.domain.Employee;

public interface SaveEmployee {
    
    Employee save(Employee employee);

}
