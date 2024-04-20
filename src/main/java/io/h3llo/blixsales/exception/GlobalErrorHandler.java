package io.h3llo.blixsales.exception;

import io.h3llo.blixsales.dto.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse<CustomErrorResponse>> handleAllException(ModelNotFoundException ex, WebRequest req){

        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));

        return new ResponseEntity<>(new GenericResponse<>(404, "error", Arrays.asList(errorResponse)), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<GenericResponse<CustomErrorResponse>> handleModelNotFoundException(ModelNotFoundException ex, WebRequest req){

        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));

        return new ResponseEntity<>(new GenericResponse<>(404, "error", Arrays.asList(errorResponse)), HttpStatus.NOT_FOUND);

    }


}
