package com.sa.healntrack.report_service.report.application.port.out;

public interface PdfEngine {
    byte[] toPdf(String html, String baseUrl);
}
