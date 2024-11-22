package com.example.demo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
// evento que diz que o usuario foi cadastrado no log
@Component
public class UserCreationLogger implements ApplicationListener<UserCreatedEvent> {

    @Override
    public void onApplicationEvent(UserCreatedEvent event) {
        System.out.println("Novo usuário criado: " + event.getUsuario().getNome());
        
    }
}
