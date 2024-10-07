package redis.project_2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import redis.project_2.model.Error;

@RestControllerAdvice
public class CustomHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleGenericException(Exception e) {
        Error error = new Error();
        error.setMessage("Непередбачена помилка: " + e.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }
}