package com.sa.healntrack.report_service.report.infrastructure.adapter.out.generate;

import com.sa.healntrack.report_service.common.infrastructure.config.ReportProperties;
import com.sa.healntrack.report_service.report.application.port.out.GeneratePdf;
import com.sa.healntrack.report_service.report.application.port.out.HtmlRenderer;
import com.sa.healntrack.report_service.report.application.port.out.PdfEngine;
import com.sa.healntrack.report_service.report.domain.value_object.ReportPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneratePdfImpl implements GeneratePdf {

    private final HtmlRenderer htmlRenderer;
    private final PdfEngine pdfEngine;
    private final ReportProperties props;

    @Override
    public byte[] generate(ReportPayload payload) {
        String html = htmlRenderer.render(props.getTemplateName(), payload.data());
        return pdfEngine.toPdf(html, props.getBaseUrl());
    }
}
