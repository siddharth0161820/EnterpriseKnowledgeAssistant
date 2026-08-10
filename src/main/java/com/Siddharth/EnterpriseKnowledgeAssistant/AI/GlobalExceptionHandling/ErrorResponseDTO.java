package com.Siddharth.EnterpriseKnowledgeAssistant.AI.GlobalExceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponseDTO {
    //1>Attributes
    private final String message;
    private final HttpStatus httpStatus;
}
