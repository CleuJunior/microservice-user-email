package br.com.ms.email.consumer;

import br.com.ms.email.dto.EmailRequest;
import br.com.ms.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    private final EmailService service;


    public EmailConsumer(EmailService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRequest request) {
        this.service.sendEmail(request);
    }
}
