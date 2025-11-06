package com.sa.healntrack.report_service.report.infrastructure.adapter.out.flyingsaucer;

import com.itextpdf.text.pdf.BaseFont;
import com.sa.healntrack.report_service.common.application.exception.ReportGenerationException;
import com.sa.healntrack.report_service.report.application.port.out.PdfEngine;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Component
public class FlyingSaucerPdfEngine implements PdfEngine {

    @Override
    public byte[] toPdf(String html, String baseUrl) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html, baseUrl);

            ITextFontResolver fonts = renderer.getFontResolver();
            registerIfExists(fonts, "templates/fonts/Inter-Regular.ttf");
            registerIfExists(fonts, "templates/fonts/Inter-Bold.ttf");

            renderer.layout();
            renderer.createPDF(baos, true);
            return baos.toByteArray();
        } catch (Exception e) {
            throw new ReportGenerationException("Error generating PDF", e);
        }
    }

    private void registerIfExists(ITextFontResolver fonts, String cpPath) {
        try (InputStream ignored = new ClassPathResource(cpPath).getInputStream()) {
            fonts.addFont(cpPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (Exception ignore) {
        }
    }
}
