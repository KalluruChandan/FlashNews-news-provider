package app.flashnews.news_provider.model.response;

import app.flashnews.news_provider.enumeration.APIResponseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> {

    private String responseId;
    private APIResponseStatus apiResponseStatus;
    private String responseMessage;
    private String displayMessage;
    private T result;

    public static <T> APIResponse<T> success(String responseMessage, String displayMessage, T result){
        return new APIResponse<T>(
                UUID.randomUUID().toString(),
                APIResponseStatus.SUCCESS,
                responseMessage,
                displayMessage,
                result
        );
    }

    public static <T> APIResponse<T> failure(String responseMessage, String displayMessage){
        return new APIResponse<T>(
                UUID.randomUUID().toString(),
                APIResponseStatus.FAILURE,
                responseMessage,
                displayMessage,
                null
        );
    }

    public static <T> APIResponse<T> failure(T errorList, String responseMessage, String displayMessage){
        return new APIResponse<T>(
                UUID.randomUUID().toString(),
                APIResponseStatus.FAILURE,
                responseMessage,
                displayMessage,
                errorList
        );
    }

}
