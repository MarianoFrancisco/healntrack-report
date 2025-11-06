package com.sa.healntrack.report_service.report.domain.value_object;

import java.math.BigDecimal;

public record Row(String date, String area, String concept, BigDecimal amount) {
}