package com.sa.healntrack.report_service.report.application.service;

import com.sa.healntrack.report_service.report.application.port.in.GenerateProfitsReport;
import com.sa.healntrack.report_service.report.application.port.out.GeneratePdf;
import com.sa.healntrack.report_service.report.domain.value_object.ReportPayload;
import com.sa.healntrack.report_service.report.domain.value_object.Row;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenerateProfitsReportImpl implements GenerateProfitsReport {

    private final GeneratePdf generatePdf;

    private static final ZoneId GT_ZONE = ZoneId.of("America/Guatemala");
    private static final DateTimeFormatter TS_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final String CURRENCY_PREFIX = "Q";

    @Override
    public byte[] handle(LocalDate from, LocalDate to, Long areaId) {
        List<Row> rows = mockData();
        Map<String, List<Row>> groupedByArea = rows.stream()
                .collect(Collectors.groupingBy(Row::area, LinkedHashMap::new, Collectors.toList()));
        List<Map<String, Object>> groups = buildGroupedSections(groupedByArea);
        BigDecimal total = calculateTotal(rows);
        Map<String, Object> model = buildModel(from, to, areaId, groups, total);
        return generatePdf.generate(new ReportPayload(model));
    }

    private List<Map<String, Object>> buildGroupedSections(Map<String, List<Row>> groupedByArea) {
        List<Map<String, Object>> groups = new ArrayList<>();

        for (Map.Entry<String, List<Row>> entry : groupedByArea.entrySet()) {
            BigDecimal subtotal = calculateTotal(entry.getValue());

            List<Map<String, Object>> groupRows = entry.getValue()
                    .stream()
                    .map(this::mapRow)
                    .toList();

            Map<String, Object> group = Map.of(
                    "label", entry.getKey(),
                    "rows", groupRows,
                    "totals", Map.of(
                            "labelCol", 1,
                            "values", Map.of("amount", formatCurrency(subtotal))
                    )
            );
            groups.add(group);
        }
        return groups;
    }

    private Map<String, Object> buildModel(LocalDate from, LocalDate to, Long areaId,
                                           List<Map<String, Object>> groups, BigDecimal total) {
        return Map.of(
                "meta", Map.of(
                        "title", "Reporte de Ganancias",
                        "subtitle", "Del %s al %s".formatted(from, to),
                        "generatedAt", TS_FMT.format(ZonedDateTime.now(GT_ZONE))
                ),
                "filters", List.of(
                        Map.of("label", "Área", "value", areaId == null ? "(todas)" : areaId),
                        Map.of("label", "Desde", "value", from),
                        Map.of("label", "Hasta", "value", to)
                ),
                "sections", List.of(
                        Map.of(
                                "type", "grouped-table",
                                "title", "Ganancias por área",
                                "columns", List.of(
                                        Map.of("field", "date", "header", "Fecha"),
                                        Map.of("field", "concept", "header", "Concepto"),
                                        Map.of("field", "amount", "header", "Monto", "align", "right")
                                ),
                                "groups", groups
                        ),
                        Map.of(
                                "type", "table",
                                "title", "Totales",
                                "columns", List.of(
                                        Map.of("field", "label", "header", "Tipo"),
                                        Map.of("field", "value", "header", "Monto", "align", "right")
                                ),
                                "rows", List.of(
                                        Map.of("label", "TOTAL GENERAL", "value", formatCurrency(total))
                                )
                        )
                )
        );
    }

    private BigDecimal calculateTotal(List<Row> rows) {
        return rows.stream()
                .map(Row::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Map<String, Object> mapRow(Row row) {
        return Map.of(
                "date", row.date(),
                "concept", row.concept(),
                "amount", formatCurrency(row.amount())
        );
    }

    private String formatCurrency(BigDecimal amount) {
        return CURRENCY_PREFIX + amount.toPlainString();
    }

    private List<Row> mockData() {
        return List.of(
                new Row("2025-09-01", "Farmacia", "Venta medicamentos", new BigDecimal("1000.00")),
                new Row("2025-09-06", "Farmacia", "Venta medicamentos", new BigDecimal("2000.00")),
                new Row("2025-09-01", "Consultas", "Consulta general", new BigDecimal("500.00")),
                new Row("2025-09-03", "Consultas", "Consulta pediátrica", new BigDecimal("500.00"))
        );
    }
}
