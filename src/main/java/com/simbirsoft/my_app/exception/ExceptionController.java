package com.simbirsoft.my_app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.apache.commons.lang3.StringUtils.isBlank;

@ControllerAdvice
@Slf4j
public class ExceptionController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        ErrorMessage message = new ErrorMessage("Error", extractError(ex));
        return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ErrorMessage message = new ErrorMessage("Error", extractError(ex));
        return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private String extractError(Exception e){
        return isBlank(e.getMessage()) ? e.getClass().getCanonicalName() : e.getMessage();
    }

    @ExceptionHandler(ElectricityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleElectricityNotFoundException(ElectricityNotFoundException e){
        log.trace("Electricity data not found", e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Error", extractError(e)));
    }

    @ExceptionHandler(ExpenseNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleElectricityNotFoundException(ExpenseNotFoundException e){
        log.trace("Expense data not found", e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Error", extractError(e)));
    }

    @ExceptionHandler(PermissionNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleElectricityNotFoundException(PermissionNotFoundException e){
        log.trace("Permission data not found", e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Error", extractError(e)));
    }

    @ExceptionHandler(RateNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleElectricityNotFoundException(RateNotFoundException e){
        log.trace("Rate data not found", e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Error", extractError(e)));
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleElectricityNotFoundException(RoleNotFoundException e){
        log.trace("Role data not found", e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Error", extractError(e)));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleElectricityNotFoundException(UserNotFoundException e){
        log.trace("User data not found", e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Error", extractError(e)));
    }

    @ExceptionHandler(WaterSupplyNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleElectricityNotFoundException(WaterSupplyNotFoundException e){
        log.trace("Water supply data not found", e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Error", extractError(e)));
    }
}
