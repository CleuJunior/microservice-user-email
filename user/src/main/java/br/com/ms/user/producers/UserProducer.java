package br.com.ms.user.producers;

import br.com.ms.user.dto.EmailResponse;
import br.com.ms.user.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final RabbitTemplate template;

    public UserProducer(RabbitTemplate template) {
        this.template = template;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user) {
        var response = new EmailResponse();
        response.setUserId(user.getId());
        response.setEmailTo(user.getEmail());
        response.setSubject("Cadastro realizado com sucesso!");
        response.setText(user.getName() + " seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os beneficios da plataformar");

        template.convertAndSend("", this.routingKey, response);
    }
}
