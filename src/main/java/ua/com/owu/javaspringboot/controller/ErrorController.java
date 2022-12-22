package ua.com.owu.javaspringboot.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.com.owu.javaspringboot.models.dto.ErrorDTO;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorDTO errorValidation(ConstraintViolationException e) {
        return new ErrorDTO(500, e.getMessage());
    }

}

