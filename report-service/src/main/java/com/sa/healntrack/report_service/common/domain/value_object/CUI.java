package com.sa.healntrack.report_service.common.domain.value_object;

import java.util.regex.Pattern;

public record CUI(String value) {
    
    private static final int CUI_LENGTH = 13;
    private static final Pattern CUI_PATTERN = Pattern.compile("^\\d{" + CUI_LENGTH +"}$");

    public CUI {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El CUI no puede ser nulo");
        }
        if (!CUI_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("El CUI debe ser de exactamente " + CUI_LENGTH + " digitos");
        }
    }

}
