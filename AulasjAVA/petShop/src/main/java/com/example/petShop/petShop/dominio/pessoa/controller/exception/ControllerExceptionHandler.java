package com.example.petShop.petShop.dominio.pessoa.controller.exception;

import com.example.petShop.petShop.dominio.produto.service.exception.ControllerNotFoundException;
import com.example.petShop.petShop.dominio.produto.service.exception.DatabaseException;
import com.example.petShop.petShop.dominio.produto.service.exception.DefaultError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    private DefaultError error = new DefaultError();
    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<DefaultError> entityNotFound(ControllerNotFoundException exeption, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Entidade não encontrada");
        error.setMessage(exeption.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(this.error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<DefaultError> entityNotFound(DatabaseException exeption, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Entidade não encontrada");
        error.setMessage(exeption.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(this.error);
    }
}
