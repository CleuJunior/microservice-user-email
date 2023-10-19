package br.com.ms.user.controller;

import br.com.ms.user.dto.UserRequest;
import br.com.ms.user.dto.UserResponse;
import br.com.ms.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponse> saveUser(@RequestBody @Valid UserRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.service.saveUser(request));
    }
}
