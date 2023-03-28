package com.rodrigo.pessoa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePessoaNotFoundException(PessoaNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse("Pessoa não encontrada", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ErrorResponse> errorResponses = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach(error ->
                errorResponses.add(new ErrorResponse(((FieldError) error).getField(), error.getDefaultMessage()))
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponses);
    }
}
