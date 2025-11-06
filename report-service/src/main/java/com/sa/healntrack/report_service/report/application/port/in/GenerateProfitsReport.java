package com.sa.healntrack.report_service.report.application.port.in;

import java.time.LocalDate;

public interface GenerateProfitsReport {
    byte[] handle(LocalDate from, LocalDate to, Long areaId);
}
