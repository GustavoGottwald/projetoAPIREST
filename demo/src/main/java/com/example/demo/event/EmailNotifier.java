package com.example.demo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
//evento de exemplo caso um email fosse enviado pro usuario assim que ele fosse cadastrado

@Component
public class EmailNotifier implements ApplicationListener<UserCreatedEvent> {
    @Override
    public void onApplicationEvent(UserCreatedEvent event) {
        System.out.println("Enviando e-mail para: " + event.getUsuario().getEmail());
    }
}