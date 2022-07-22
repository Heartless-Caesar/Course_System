package com.example.course_system.ErrorHandling;

import com.example.course_system.Entities.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentExceptionHandler.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentExceptionHandler exception,
                                                                   WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
