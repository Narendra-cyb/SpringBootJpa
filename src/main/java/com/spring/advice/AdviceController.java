package com.spring.advice;


import com.spring.exception.ResouceNotFoundHandlerException;
import com.spring.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(ResouceNotFoundHandlerException.class)
    public ResponseEntity<ErrorDetails> handlerExceptionCourseNotFound(ResouceNotFoundHandlerException e){
        System.out.println("AdviceController.handlerExceptionCourseNotFound");
        ErrorDetails details = new ErrorDetails(e.getMessage(), HttpStatus.NOT_FOUND,LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
