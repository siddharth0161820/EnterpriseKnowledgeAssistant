package com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatControllerLayer;

import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO.ChatRequestDTO;
import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO.ChatResponseDTO;
import com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatServiceLayer.ChatService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    // General AI
    @PostMapping("/general")
    public ResponseEntity<ChatResponseDTO> generalChat(
            @Valid @RequestBody ChatRequestDTO request) {

        return ResponseEntity.ok(
                chatService.chatWithAi(request)
        );
    }

    // PDF + Question
    @PostMapping(
            value = "/pdf",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<ChatResponseDTO> chatWithPdf(
            @RequestPart("file") MultipartFile file,
            @RequestPart("question") String question) {

        return ResponseEntity.ok(
                chatService.chatWithPdf(file, question)
        );
    }
}