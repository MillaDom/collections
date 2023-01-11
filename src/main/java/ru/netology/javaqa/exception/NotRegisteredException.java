package ru.netology.javaqa.exception;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String msg){
        super(msg);
    }
}
