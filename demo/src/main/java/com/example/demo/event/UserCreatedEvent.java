package com.example.demo.event;

import com.example.demo.model.Usuario;
import org.springframework.context.ApplicationEvent;
// evento da criação do usuario
// os eventos EmailNotifier e UserCreationLogger reagem a esse evento e fazem suas ações
public class UserCreatedEvent extends ApplicationEvent {
    private final Usuario user;

    public UserCreatedEvent(Object source, Usuario user) {
        super(source);
        this.user = user;
    }

    public Usuario getUsuario() {
        return user;
    }
}