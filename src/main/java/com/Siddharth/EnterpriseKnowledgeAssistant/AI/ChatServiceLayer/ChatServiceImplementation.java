package com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatServiceLayer;

import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO.ChatRequestDTO;
import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO.ChatResponseDTO;
import com.Siddharth.EnterpriseKnowledgeAssistant.AI.Ingestion.pdf.PdfContextStore;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChatServiceImplementation implements ChatService {

    // Inject PdfContextStore
    private final PdfContextStore pdfContextStore;

    // Inject ChatClient
    private final ChatClient chatClient;

    @Override
    public ChatResponseDTO chatWithAi(ChatRequestDTO chatRequestDTO) {

        // Get PDF text from PdfContextStore
        String pdfText = pdfContextStore.getPdfText();

        // Send PDF text + user's question to Gemini
        String response = chatClient.prompt()
                .user("""
                        PDF:
                        %s

                        Question:
                        %s
                        """.formatted(pdfText, chatRequestDTO.getQuestion()))
                .call()
                .content();

        return new ChatResponseDTO(response);
    }
}