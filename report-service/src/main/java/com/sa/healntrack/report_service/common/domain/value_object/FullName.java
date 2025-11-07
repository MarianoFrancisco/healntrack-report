package com.sa.healntrack.report_service.common.domain.value_object;

import java.util.regex.Pattern;

public record FullName(String value) {

    private static final int MIN_LENGTH = 2;
    private static final Pattern FULL_NAME_PATTERN = Pattern.compile("^[\\p{L} ']+$");

    public FullName {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        if (value.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(
                    "El nombre debe superar los " + MIN_LENGTH + " caracteres");
        }
        if (!FULL_NAME_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("El nombre no tiene un formato valido");
        }
        value = normalize(value);
    }

    private static String normalize(String value) {
        return value.trim().replaceAll("//s+", "");
    }
    
}
