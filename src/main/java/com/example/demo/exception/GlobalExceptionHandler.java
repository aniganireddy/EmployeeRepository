package com.example.demo.exception;

import com.example.demo.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorDetails> employeeNotFoundExceptionResponseEntity(EmployeeNotFoundException employeeNotFoundException, WebRequest webRequest){
ErrorDetails errorDetails = new ErrorDetails(
        LocalDateTime.now(),
        employeeNotFoundException.getMessage(),
        webRequest.getDescription(false),
        "400.010.EmployeeNotExists"
);

return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
