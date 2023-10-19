package br.com.ms.email.dto;

import br.com.ms.email.enums.StatusEmail;
import br.com.ms.email.model.Email;
import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.UUID;

public record EmailResponse(
        UUID emailId,
        UUID userId,
        String emailFrom,
        String emailTo,
        String subject,
        String text,
        LocalDateTime sendDateEmail,
        StatusEmail statusEmail
) {
    public EmailResponse(Email email) {
        this(
                email.getEmailId(),
                email.getUserId(),
                email.getEmailFrom(),
                email.getEmailTo(),
                email.getSubject(),
                email.getText(),
                email.getSendDateEmail(),
                email.getStatusEmail()
        );
    }
}
