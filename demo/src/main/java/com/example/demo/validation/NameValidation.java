package com.example.demo.validation;

public class NameValidation implements ValidationStrategy {
    @Override
    public boolean validate(String input) {
        return input != null && input.length() > 2;
    }
}