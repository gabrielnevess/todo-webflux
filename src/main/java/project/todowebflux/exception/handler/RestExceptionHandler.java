package project.todowebflux.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
@Slf4j
class RestExceptionHandler {

    @ExceptionHandler(WebExchangeBindException.class)
    private ResponseEntity<Object> handleMethodArgumentNotValid(WebExchangeBindException methodArgumentNotValidException) {
        List<RestError> restErrors = new ArrayList<RestError>();
        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        return new ResponseEntity<>(fieldErrors.stream().map(fieldError -> {
            return RestError.builder()
                    .field(fieldError.getField())
                    .timestamp(new Date())
                    .message("validation error")
                    .details(fieldError.getDefaultMessage())
                    .build();
        }), methodArgumentNotValidException.getStatus());
    }

}
