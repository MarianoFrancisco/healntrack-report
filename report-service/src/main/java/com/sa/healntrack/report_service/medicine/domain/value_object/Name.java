package com.sa.healntrack.report_service.medicine.domain.value_object;

public record Name(String value) {

    public Name {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (value.length() > 120) {
            throw new IllegalArgumentException("El nombre supera 120 caracteres");
        }
        value = value.trim();
    }
    
}
