package com.Siddharth.EnterpriseKnowledgeAssistant.AI.ChatDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ChatRequestDTO {
    //1>Fields
    @NotBlank(message = "Questions cannot be empty")
    private String question;
}
