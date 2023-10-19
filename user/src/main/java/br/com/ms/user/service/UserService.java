package br.com.ms.user.service;

import br.com.ms.user.dto.UserRequest;
import br.com.ms.user.dto.UserResponse;
import br.com.ms.user.model.User;
import br.com.ms.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserResponse saveUser(UserRequest request) {
        User user = User
                .builder()
                .name(request.name())
                .email(request.email())
                .build();

        this.repository.save(user);

        return new UserResponse(user);
    }
}
