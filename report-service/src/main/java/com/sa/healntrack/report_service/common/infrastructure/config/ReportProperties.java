package com.sa.healntrack.report_service.common.infrastructure.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "report")
@Getter
public class ReportProperties {

    private String baseUrl = "classpath:/templates/";
    private String templateName = "reports/universal";
}
