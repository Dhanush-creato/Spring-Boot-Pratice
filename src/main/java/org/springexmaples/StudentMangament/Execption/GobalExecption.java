package org.springexmaples.StudentMangament.Execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GobalExecption {
@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> myMethodArugement(MethodArgumentNotValidException e){
        Map<String,String> execption = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(err->{
            String fieldname = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            execption.put(fieldname,message);
        });
        return new ResponseEntity<>(execption, HttpStatus.BAD_REQUEST) ;
    }
}
