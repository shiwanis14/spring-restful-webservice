package com.ownprojects.rest.webservice.restfulwebservice.Exception;

import java.util.Date;
import com.ownprojects.rest.webservice.restfulwebservice.Users.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionResponseEntityHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request)
      throws Exception {
    BaseExceptionResponse baseExceptionResponse = new BaseExceptionResponse(new Date(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(baseExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public final ResponseEntity<Object> handleUserNotFoundExceptions(Exception ex, WebRequest request)
      throws Exception {
    BaseExceptionResponse baseExceptionResponse = new BaseExceptionResponse(new Date(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(baseExceptionResponse, HttpStatus.NOT_FOUND);
  }

//validations
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    BaseExceptionResponse baseExceptionResponse = new BaseExceptionResponse(new Date(),
       "Request Validation failed", ex.getBindingResult().toString());
    return new ResponseEntity<>(baseExceptionResponse, HttpStatus.BAD_REQUEST);
  }

}

