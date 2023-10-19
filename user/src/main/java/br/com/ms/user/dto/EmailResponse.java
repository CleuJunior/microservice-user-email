package br.com.ms.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailResponse {
    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
