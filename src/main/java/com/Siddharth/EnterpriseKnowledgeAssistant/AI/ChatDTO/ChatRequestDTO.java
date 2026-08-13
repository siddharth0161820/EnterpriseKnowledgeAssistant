package com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChatRequestDTO {
    @NotBlank(message = "Question cannot be empty")
    private String question;
}