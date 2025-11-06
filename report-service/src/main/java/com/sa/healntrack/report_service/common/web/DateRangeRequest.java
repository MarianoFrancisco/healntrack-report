package com.sa.healntrack.report_service.common.web;

import java.time.LocalDate;

public record DateRangeRequest(LocalDate from, LocalDate to, Long areaId) {
}
