package com.example.demo.validation;

// o padrão Strategy foi aplicado para validar os dados do usuário (como nome e e-mail) antes de salvá-los no banco de dados.
//  O objetivo do padrão Strategy aqui é encapsular as diferentes estratégias de validação, 
//  tornando o sistema flexível e fácil de estender.

public interface ValidationStrategy {
    boolean validate(String input);
}