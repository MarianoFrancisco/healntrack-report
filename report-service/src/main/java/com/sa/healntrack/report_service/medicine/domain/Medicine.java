package com.sa.healntrack.report_service.medicine.domain;

import java.util.UUID;

import com.sa.healntrack.report_service.medicine.domain.value_object.MedicineId;
import com.sa.healntrack.report_service.medicine.domain.value_object.Name;

import lombok.Getter;

@Getter
public class Medicine {

    private final MedicineId id;
    private Name name;

    public Medicine(UUID id, String name) {
        this.id = new MedicineId(UUID.randomUUID());
        this.name = new Name(name);
    }

    public void updateName(String name) {
        this.name = new Name(name);
    }

}
