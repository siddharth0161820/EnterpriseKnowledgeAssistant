package com.Siddharth.EnterpriseKnowledgeAssistant.AI.Ingestion.pdf;

import lombok.AllArgsConstructor;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@AllArgsConstructor
public class PdfIngestionService {

    // Inject PdfContextStore
    private final PdfContextStore pdfContextStore;

    // Path of folder containing PDFs
    private static final String PDF_DIRECTORY = "NexaCorpData/pdfs";

    public void ingestPdfs() throws Exception {

        // Locate PDF folder
        File directory = new File(PDF_DIRECTORY);

        // Get all files inside the folder
        File[] pdfFiles = directory.listFiles();

        // Process each PDF
        for (File pdfFile : pdfFiles) {

            // Load PDF using PDFBox
            PDDocument document = Loader.loadPDF(pdfFile);

            // Extract text from PDF
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            // Store extracted text
            pdfContextStore.setPdfText(text);

            // Print extracted text
            System.out.println(text);

            // Close PDF
            document.close();
        }
    }
}