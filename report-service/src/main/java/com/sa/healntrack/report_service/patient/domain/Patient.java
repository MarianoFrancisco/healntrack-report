package com.sa.healntrack.report_service.patient.domain;

import java.util.UUID;

import com.sa.healntrack.report_service.common.domain.value_object.CUI;
import com.sa.healntrack.report_service.common.domain.value_object.FullName;
import com.sa.healntrack.report_service.patient.domain.value_object.PatientId;

import lombok.Getter;

@Getter
public class Patient {

    private final PatientId id;
    private final CUI cui;
    private FullName fullName;

    public Patient(UUID id, String cui, String fullName) {
        this.id = new PatientId(id);
        this.cui = new CUI(cui);
        this.fullName = new FullName(fullName);
    }

    public void updateFullName(String fullName) {
        this.fullName = new FullName(fullName);
    }
    
}
