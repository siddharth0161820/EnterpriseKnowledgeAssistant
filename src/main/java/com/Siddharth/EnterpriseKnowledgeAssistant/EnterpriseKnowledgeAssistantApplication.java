package com.Siddharth.EnterpriseKnowledgeAssistant;

import com.Siddharth.EnterpriseKnowledgeAssistant.AI.Ingestion.pdf.PdfIngestionService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class EnterpriseKnowledgeAssistantApplication implements CommandLineRunner {

	// Inject PdfIngestionService
	private final PdfIngestionService pdfIngestionService;

	public static void main(String[] args) {

		SpringApplication.run(
				EnterpriseKnowledgeAssistantApplication.class,
				args
		);

		System.out.println("Enterprise Knowledge Assistant");
		System.out.println("Radhe Radhe");
	}

	@Override
	public void run(String... args) throws Exception {

		// Start PDF ingestion when application starts
		pdfIngestionService.ingestPdfs();
	}
}