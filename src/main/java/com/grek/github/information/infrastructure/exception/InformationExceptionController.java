package com.grek.github.information.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InformationExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InformationException.class)
    public ResponseEntity<?> handleInformationException(InformationException ex){
        InformationExceptionDto informationExceptionDto = new InformationExceptionDto(ex.getMessage());
        return new ResponseEntity<>(informationExceptionDto, HttpStatus.BAD_REQUEST);
    }
}
