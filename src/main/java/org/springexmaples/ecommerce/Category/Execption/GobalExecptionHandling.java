package org.springexmaples.ecommerce.Category.Execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GobalExecptionHandling {
     @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> myMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> exception = new HashMap<>();
          e.getBindingResult().getAllErrors().forEach(err->{
              String filedName = ((FieldError)err).getField();
              String message = err.getDefaultMessage();
              exception.put(filedName,message);
          });
        return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST) ;
    }
}
