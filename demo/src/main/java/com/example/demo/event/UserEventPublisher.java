package com.example.demo.event;

import com.example.demo.model.Usuario;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
//Usa a interface do spring para publicar eventos

// O Observer foi escolhido para gerenciar as reações automáticas quando um novo usuário é criado. No projeto,
// quando um usuário é criado, o UserCreatedEvent é publicado, e observadores como o EmailNotifier e UserCreationLogger reagem a esse evento,
// realizando ações como enviar um e-mail ou registrar um log.

@Component
public class UserEventPublisher {
    private final ApplicationEventPublisher publisher;

    public UserEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishUserCreatedEvent(Usuario user) {
        publisher.publishEvent(new UserCreatedEvent(this, user));
    }
}