package com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatServiceLayer;

import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO.ChatRequestDTO;
import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO.ChatResponseDTO;
import com.Siddharth.EnterpriseKnowledgeAssistant.AI.Ingestion.pdf.PdfIngestionService;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class ChatServiceImplementation implements ChatService {

    private final PdfIngestionService pdfIngestionService;
    private final ChatClient chatClient;


    // General AI
    @Override
    public ChatResponseDTO chatWithAi(ChatRequestDTO request) {

        String response = chatClient.prompt()
                .user(request.getQuestion())
                .call()
                .content();

        return new ChatResponseDTO(response);
    }


    // PDF + Question
    @Override
    public ChatResponseDTO chatWithPdf(
            MultipartFile file,
            String question) {

        if (question == null || question.isBlank()) {
            throw new IllegalArgumentException(
                    "Question cannot be empty"
            );
        }

        String pdfText =
                pdfIngestionService.extractText(file);

        String response = chatClient.prompt()
                .user("""
                Answer the user's questions using ONLY the uploaded PDF.

                PDF CONTENT:
                %s

                QUESTIONS:
                %s

                IMPORTANT RULES:
                - Answer each question separately.
                - Keep every answer concise and easy to read.
                - Do not add an introduction or conclusion.
                - Do not use Markdown bold, bullet points, or asterisks.
                - Do not repeat unnecessary information.
                - If information is not present in the PDF, write exactly:
                  The requested information was not found in the uploaded document.

                Use exactly this format:

                1. Question: <question>
                   Answer: <answer>

                2. Question: <question>
                   Answer: <answer>

                3. Question: <question>
                   Answer: <answer>

                For questions requiring a longer answer, use short numbered
                points under the Answer instead of a long paragraph.

                Do NOT use general knowledge, assumptions, or information
                outside the uploaded PDF.
                """.formatted(pdfText, question))
                .call()
                .content();

        return new ChatResponseDTO(response);
    }
}