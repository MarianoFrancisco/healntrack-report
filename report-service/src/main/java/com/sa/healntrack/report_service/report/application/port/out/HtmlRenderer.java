package com.sa.healntrack.report_service.report.application.port.out;

import java.util.Map;

public interface HtmlRenderer {
    String render(String templateName, Map<String, Object> model);
}
