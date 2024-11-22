package com.example.demo.validation;

public class EmailValidation implements ValidationStrategy {
    @Override
    public boolean validate(String input) {
        return input != null && input.contains("@") && input.contains(".");
    }
}