# 🤖 Enterprise Knowledge Assistant – Spring Boot & Google Gemini

A practical **Spring Boot AI backend application** demonstrating **REST API development, Google Gemini integration, PDF document processing with Apache PDFBox, DTO validation, MySQL connectivity, and clean layered architecture**.

Built with a strong focus on **Java backend fundamentals, AI integration, document-based question answering, API design, and production-oriented development patterns**, suitable for Java Backend Developer and AI-enabled backend roles.

[![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Spring AI](https://img.shields.io/badge/Spring%20AI-1.1.8-green?logo=spring)](https://spring.io/projects/spring-ai)
[![Google Gemini](https://img.shields.io/badge/Google%20Gemini-AI-blue?logo=google)](https://ai.google.dev/)
[![Apache PDFBox](https://img.shields.io/badge/Apache%20PDFBox-3.0.6-red)](https://pdfbox.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-Database-blue?logo=mysql)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Maven-Build-red?logo=apachemaven)](https://maven.apache.org/)


---

## 🚀 Tech Stack

| Category | Technology |
|---|---|
| **Language** | Java 21 |
| **Framework** | Spring Boot 3.5.6 |
| **AI Integration** | Spring AI 1.1.8 + Google Gemini |
| **PDF Processing** | Apache PDFBox 3.0.6 |
| **Database** | MySQL |
| **Persistence** | Spring Data JPA / Hibernate |
| **API** | Spring Web / REST |
| **Validation** | Jakarta Bean Validation |
| **Build Tool** | Maven |
| **Testing** | Spring Boot Test |
| **API Testing** | Postman |
| **Monitoring** | Spring Boot Actuator |

---
## 🧩 Architecture Overview

The application follows a clean **layered architecture** where the REST API receives the user's question, the service layer prepares the PDF context, and Google Gemini generates the final response.

### Request Flow

```text
User
 ↓
ChatController
 ↓
ChatService
 ↓
PdfContextStore
 ↓
Google Gemini
 ↓
ChatResponse
 ↓
User
```

---
## 📄 PDF Ingestion & AI Processing

The application uses **Apache PDFBox** to load the enterprise PDF and extract its text. The extracted content is temporarily stored and then provided to Google Gemini along with the user's question.

### Processing Flow

```text
PDF Document
     ↓
PdfIngestionService
     ↓
Apache PDFBox
     ↓
Text Extraction
     ↓
PdfContextStore
     ↓
ChatService
     ↓
PDF Context + User Question
     ↓
Google Gemini
     ↓
AI Response
```

### PDF Ingestion Architecture

![PDF Ingestion and AI Processing Flow](docs/architecture/02_PDF_Ingestion_and_AI_Processing_Flow.png)

### Key Components

| Component | Responsibility |
|---|---|
| **PdfIngestionService** | Loads PDF files and extracts text using Apache PDFBox |
| **PdfContextStore** | Temporarily stores the extracted PDF text |
| **ChatService** | Combines the PDF context with the user's question |
| **ChatController** | Exposes the REST API |
| **Google Gemini** | Generates the final AI response |

> **Current implementation:** The application uses direct PDF text context with Gemini. It does not currently use embeddings, a vector database, or semantic similarity search.

---
## 💬 Chat API

The application exposes a REST API that accepts a user's question and returns an AI-generated response based on the available PDF context.

### Endpoint

```http
POST /api/chat/chatWithAi
```

### Request

```json
{
  "question": "How does NexaCorp's Role-Based Access Control work, and what happens to system access when an employee leaves the company?"
}
```

### Response

```json
{
  "answer": "Based on NexaCorp's IT Access Control Policy, access is assigned based on employee roles such as Engineering, HR, Support, and Operations. Elevated privileges are granted only when justified by business needs. Upon employee termination or role change, system access must be reviewed and adjusted, and access to critical systems must be revoked immediately upon exit."
}
```

### API Flow

```text
Client
  ↓
POST /api/chat/chatWithAi
  ↓
ChatController
  ↓
ChatService
  ↓
PDF Context + User Question
  ↓
Google Gemini
  ↓
ChatResponseDTO
  ↓
Client
```

### API Demonstration

![PDF Based Question Answering](docs/screenshots/03_IT_Access_Control_PDF_Query.png)

---








