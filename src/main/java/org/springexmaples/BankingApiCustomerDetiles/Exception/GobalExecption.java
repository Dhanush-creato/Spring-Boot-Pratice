package org.springexmaples.BankingApiCustomerDetiles.Exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GobalExecption {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> myExcption(MethodArgumentNotValidException e){
        Map<String,String> excption = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(err->{
            String fileldName = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            excption.put(fileldName,message);

        });
        return new ResponseEntity<>(excption, HttpStatus.BAD_REQUEST);
    }



        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<String> handleDuplicate(DataIntegrityViolationException ex) {

            String message = "Duplicate value found!";

            if (ex.getMessage().contains("email")) {
                message = message +" Email already exists";
            }
            if (ex.getMessage().contains("mobile")) {
                message = message+ " Mobile number already exists";
            }

            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<String> myResponseException(ResourceNotFoundException e){
             String message = e.getMessage();

             return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
    }

