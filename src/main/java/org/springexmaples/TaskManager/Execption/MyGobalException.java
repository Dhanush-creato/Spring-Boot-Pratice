package org.springexmaples.TaskManager.Execption;

import org.springexmaples.BankingApiCustomerDetiles.Exception.ResourceNotFoundException;
import org.springexmaples.TaskManager.payload.ApiResponse;
import org.springexmaples.ecommerce.Category.Execption.ApiExecption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyGobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> myMethodArugumentValidation(MethodArgumentNotValidException e){
        Map<String ,String> exception = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(err->{
            String fieldName = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            exception.put(fieldName,message);

        });
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> myResourceNotFoundException(ResourceNotFoundException e){
        String message = e.getMessage();
        ApiResponse apiResponse = new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ApiExecption.class)
    public ResponseEntity<ApiResponse> myApiExpection(ApiExecption e){
        String message = e.getMessage();
        ApiResponse apiResponse = new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }
}
