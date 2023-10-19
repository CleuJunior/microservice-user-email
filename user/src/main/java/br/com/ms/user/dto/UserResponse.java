package br.com.ms.user.dto;

import br.com.ms.user.model.User;

import java.util.UUID;

public record UserResponse(UUID id, String name, String email) {

    public UserResponse(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
