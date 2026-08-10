package com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatControllerLayer;

import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO.ChatRequestDTO;
import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO.ChatResponseDTO;
import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatServiceLayer.ChatService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {

    // Inject ChatService
    private final ChatService chatService;

    @PostMapping("/chatWithAi")
    public ResponseEntity<ChatResponseDTO> chatWithAi(
            @Valid @RequestBody ChatRequestDTO chatRequestDTO) {

        ChatResponseDTO response = chatService.chatWithAi(chatRequestDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}