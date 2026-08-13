package com.Siddharth.EnterpriseKnowledgeAssistant.AI.Ingestion.pdf;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PdfIngestionService {

    public String extractText(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException(
                    "PDF file cannot be empty"
            );
        }

        try {
            PDDocument document =
                    Loader.loadPDF(file.getBytes());

            try (document) {

                PDFTextStripper stripper =
                        new PDFTextStripper();

                String text = stripper.getText(document);

                if (text == null || text.isBlank()) {
                    throw new IllegalArgumentException(
                            "PDF does not contain readable text"
                    );
                }

                return text;
            }

        } catch (IllegalArgumentException e) {

            throw e;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to read PDF",
                    e
            );
        }
    }
}