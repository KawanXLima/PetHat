package com.projetopm.veterinaria.model.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class ExceptionConfig  {

    @ExceptionHandler({EmptyResultDataAccessException.class, RuntimeException.class})
    public ResponseEntity errorNotFound(Exception exception){
        return new ResponseEntity<>(new ExceptionError("Requisição não encontrada"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity errorBadRequest(Exception exception){
        return new ResponseEntity<>(new ExceptionError("Requisição ilegal"), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity handleHttpRequestMethodNotSupported() {
        return new ResponseEntity<>(new ExceptionError("Operação não permitida"), HttpStatus.METHOD_NOT_ALLOWED);
    }

    public class ExceptionError {
        private String error;
        ExceptionError(String error){
            this.error = error;
        }

        public String getError(){
            return error;
        }
    }

}