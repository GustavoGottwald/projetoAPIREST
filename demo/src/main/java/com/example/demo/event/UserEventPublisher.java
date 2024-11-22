package com.example.demo.event;

import com.example.demo.model.Usuario;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
//Usa a interface do spring para disparar eventos, nesse caso dispara o UserCreatedEvent

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