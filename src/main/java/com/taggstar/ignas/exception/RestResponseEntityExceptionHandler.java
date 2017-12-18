package com.taggstar.ignas.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ VisitorNotFoundException.class })
    public ResponseEntity<Object> handleAccessDeniedException() {
        return new ResponseEntity<>("Visitor NOT found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}
