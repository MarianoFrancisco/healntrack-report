package com.sa.healntrack.report_service.report.application.port.out;

import com.sa.healntrack.report_service.report.domain.value_object.ReportPayload;

public interface GeneratePdf {
    byte[] generate(ReportPayload payload);
}
