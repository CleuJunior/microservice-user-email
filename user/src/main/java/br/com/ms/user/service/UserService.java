package br.com.ms.user.service;

import br.com.ms.user.dto.UserRequest;
import br.com.ms.user.dto.UserResponse;
import br.com.ms.user.model.User;
import br.com.ms.user.producers.UserProducer;
import br.com.ms.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserProducer producer;

    public UserService(UserRepository repository, UserProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @Transactional
    public UserResponse saveUser(UserRequest request) {
        User user = User
                .builder()
                .name(request.name())
                .email(request.email())
                .build();

        this.repository.save(user);
        this.producer.publishMessageEmail(user);

        return new UserResponse(user);
    }
}
