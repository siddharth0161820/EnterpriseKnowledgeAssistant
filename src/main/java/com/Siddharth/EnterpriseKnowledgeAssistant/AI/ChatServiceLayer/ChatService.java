package com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatServiceLayer;

import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO.ChatRequestDTO;
import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO.ChatResponseDTO;

public interface ChatService {
    public ChatResponseDTO chatWithAi(ChatRequestDTO chatRequestDTO);
}
