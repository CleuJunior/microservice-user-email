package br.com.ms.email.services;

import br.com.ms.email.dto.EmailRequest;
import br.com.ms.email.dto.EmailResponse;
import br.com.ms.email.enums.StatusEmail;
import br.com.ms.email.model.Email;
import br.com.ms.email.repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    private final EmailRepository repository;
    private final JavaMailSender mailSender;
    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    public EmailService(EmailRepository repository, JavaMailSender mailSender) {
        this.repository = repository;
        this.mailSender = mailSender;
    }


    @Transactional
    public EmailResponse sendEmail(EmailRequest request) {
        Email email = Email
                .builder()
                .userId(request.userId())
                .emailFrom(this.emailFrom)
                .emailTo(request.emailTo())
                .subject(request.subject())
                .text(request.text())
                .sendDateEmail(LocalDateTime.now())
                .build();

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(request.emailTo());
            message.setSubject(request.subject());
            message.setText(request.text());
            this.mailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);

        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);

        } finally {
            this.repository.save(email);
        }

        return new EmailResponse(email);
    }

}
