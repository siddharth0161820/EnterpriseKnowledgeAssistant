package com.Siddharth.EnterpriseKnowledgeAssistant.AI.Ingestion.Pdf;

import com.Siddharth.EnterpriseKnowledgeAssistant.AI.Ingestion.pdf.PdfIngestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PdfIngestionServiceTest {

    //Inject service Layer
    @Autowired
    private PdfIngestionService pdfIngestionService;


    //Create a method()
    @Test
    public void testIngestPdfs() throws Exception {
      pdfIngestionService.ingestPdfs();//Actually calls your PDF ingestion code.
    }
}
