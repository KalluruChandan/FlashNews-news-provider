package app.flashnews.news_provider.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomException extends RuntimeException {

    private String displayMessage;
    private HttpStatus httpStatus;

    public CustomException(String errorMessage, String displayMessage, HttpStatus httpStatus) {
        super(errorMessage);
        this.displayMessage = displayMessage;
        this.httpStatus = httpStatus;
    }
}
