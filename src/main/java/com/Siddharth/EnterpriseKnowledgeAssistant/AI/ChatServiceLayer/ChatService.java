package com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatServiceLayer;

import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO.ChatRequestDTO;
import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO.ChatResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ChatService {

    ChatResponseDTO chatWithAi(ChatRequestDTO request);

    ChatResponseDTO chatWithPdf(
            MultipartFile file,
            String question
    );
}