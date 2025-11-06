package com.sa.healntrack.report_service.report.infrastructure.adapter.in.web;

import com.sa.healntrack.report_service.common.web.DateRangeRequest;
import com.sa.healntrack.report_service.report.application.port.in.GenerateProfitsReport;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/reports/profits")
@RequiredArgsConstructor
public class ProfitsReportController {

    private final GenerateProfitsReport useCase;

    @PostMapping(
            value = "/pdf",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    public ResponseEntity<byte[]> pdf(@Valid @RequestBody DateRangeRequest req) {
        byte[] pdfBytes = useCase.handle(req.from(), req.to(), req.areaId());

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmm"));
        String filename = String.format("profits_%s.pdf", timestamp);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + filename)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
