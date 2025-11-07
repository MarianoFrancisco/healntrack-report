package com.sa.healntrack.report_service.area.domain.value_object;

public record Name(String value) {
    
    public Name {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (value.length() > 50) {
            throw new IllegalArgumentException("El nombre supera los 50 caracteres");
        }
        value = value.trim();
    }

}
