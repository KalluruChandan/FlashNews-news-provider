package app.flashnews.news_provider.exception;

import app.flashnews.news_provider.model.response.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<APIResponse<String>> inCaseOfCustomException(CustomException ce) {
        APIResponse<String> response = APIResponse.failure(ce.getMessage(), ce.getDisplayMessage());
        return new ResponseEntity<>(response, ce.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<String>> inCaseOfAnyUnExpectedException(Exception e) {
        APIResponse<String> response = APIResponse.failure(e.getMessage(), "Server Error");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<List<String>>> inCaseOfAnyMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errorList = e.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
        APIResponse<List<String>> response = APIResponse.failure(errorList, "Bad Request Structure" ,"Cannot Process request");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
