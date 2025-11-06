package com.sa.healntrack.report_service.report.infrastructure.adapter.out.thymeleaf;

import com.sa.healntrack.report_service.report.application.port.out.HtmlRenderer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Locale;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ThymeleafHtmlRenderer implements HtmlRenderer {

    private final TemplateEngine engine;

    @Override
    public String render(String templateName, Map<String, Object> model) {
        Context ctx = new Context(Locale.of("es", "GT"));
        ctx.setVariables(model);
        return engine.process(templateName, ctx);
    }
}
