package org.soulcodeacademy.empresa.controllers.Errors;

import org.soulcodeacademy.empresa.services.errors.RecursoNãoEncontradoError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(RecursoNãoEncontradoError.class)
    public  ResponseEntity<CustomErrorResponse>RecursoNãoEncontradoError(RecursoNãoEncontradoError error, HttpServletRequest request){
        CustomErrorResponse response = new CustomErrorResponse();
        response.setMessage(error.getMessage());
        response.setPath(request.getRequestURI());
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);


    }

}
