package com.sa.healntrack.report_service.employee.domain;

import java.util.UUID;

import com.sa.healntrack.report_service.common.domain.value_object.CUI;
import com.sa.healntrack.report_service.common.domain.value_object.FullName;
import com.sa.healntrack.report_service.employee.domain.value_object.EmployeeId;

import lombok.Getter;

@Getter
public class Employee {

    private final EmployeeId id;
    private final CUI cui;
    private FullName fullName;
    
    public Employee(UUID id, String cui, String fullName) {
        this.id = new EmployeeId(id);
        this.cui = new CUI(cui);
        this.fullName = new FullName(fullName);
    }

    public void updateFullName(String fullName) {
        this.fullName = new FullName(fullName);
    }

}
