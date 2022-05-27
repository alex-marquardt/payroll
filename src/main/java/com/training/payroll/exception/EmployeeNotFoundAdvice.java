package com.training.payroll.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EmployeeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity employeeNotFoundHandler(EmployeeNotFoundException ex) {
        Map<String,Object> errorInfo = new HashMap<>();
        errorInfo.put("error status", HttpStatus.NOT_FOUND);
        errorInfo.put("error message",ex.getMessage());
        errorInfo.put("timestamp", new Date());
        return new ResponseEntity(errorInfo, HttpStatus.NOT_FOUND);
    }
}
