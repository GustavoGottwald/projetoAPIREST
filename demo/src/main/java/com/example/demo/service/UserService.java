package com.example.demo.service;

import com.example.demo.event.UserEventPublisher;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.validation.EmailValidation;
import com.example.demo.validation.NameValidation;
import com.example.demo.validation.ValidationStrategy;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UsuarioRepository usuarioRepository;
    private final UserEventPublisher userEventPublisher;

    public UserService(UsuarioRepository userRepository, UserEventPublisher userEventPublisher) {
        this.usuarioRepository = userRepository;
        this.userEventPublisher = userEventPublisher;
    }

    public Usuario saveUser(Usuario user) {
        Usuario savedUser = usuarioRepository.save(user);
        // Validações usando Strategy
        ValidationStrategy nameValidator = new NameValidation();
        ValidationStrategy emailValidator = new EmailValidation();

        if (!nameValidator.validate(user.getNome())) {
            throw new IllegalArgumentException("Nome inválido");
        }

        if (!emailValidator.validate(user.getEmail())) {
            throw new IllegalArgumentException("E-mail inválido");
        }

        // Salvar no banco
        userEventPublisher.publishUserCreatedEvent(savedUser);
        return usuarioRepository.save(user);
    }
}