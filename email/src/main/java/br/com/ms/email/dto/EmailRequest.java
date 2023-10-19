package br.com.ms.email.dto;

import java.util.UUID;

public record EmailRequest(UUID userId, String emailTo, String subject, String text) { }
