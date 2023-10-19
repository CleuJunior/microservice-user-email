package br.com.ms.email.consumer;

import br.com.ms.email.dto.EmailRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRequest email) {
        System.out.println(email.emailTo());
    }
}
