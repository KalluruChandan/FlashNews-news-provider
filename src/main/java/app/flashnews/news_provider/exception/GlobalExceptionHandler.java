package app.flashnews.news_provider.exception;

import app.flashnews.news_provider.model.response.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<APIResponse<String>> inCaseOfCustomException(CustomException ce){
        APIResponse<String> response = APIResponse.failure(ce.getMessage(), ce.getDisplayMessage());
        return new ResponseEntity<>(response, ce.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<String>> inCaseOfAnyUnExpectedException(Exception e){
        APIResponse<String> response = APIResponse.failure(e.getMessage(), "Server Error");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 }
