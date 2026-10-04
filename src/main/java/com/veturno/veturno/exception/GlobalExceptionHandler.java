package com.veturno.veturno.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> manejarErroresValidacion(
            MethodArgumentNotValidException ex) {

        List<String> errores = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        ApiError apiError = new ApiError();

        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setMensaje("Datos inválidos");
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setErrores(errores);

        return new ResponseEntity<>(
                apiError,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> manejarRuntimeException(
            RuntimeException ex) {

        ApiError apiError = new ApiError();

        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setMensaje(ex.getMessage());
        apiError.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(
                apiError,
                HttpStatus.BAD_REQUEST);
    }
}