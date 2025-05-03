package app.flashnews.news_provider.service.impl;

import app.flashnews.news_provider.exception.CustomException;
import app.flashnews.news_provider.model.response.APIResponse;
import app.flashnews.news_provider.model.response.RapidAPILangInfoResponse;
import app.flashnews.news_provider.service.ArticlesInfoProviderService;
import app.flashnews.news_provider.util.RapidAPIHeadersUtil;
import app.flashnews.news_provider.util.RestTemplateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticlesInfoProviderServiceImpl implements ArticlesInfoProviderService {

    private final RestTemplateUtil restTemplateUtil;
    private final RapidAPIHeadersUtil rapidAPIHeadersUtil;
    private final ObjectMapper objectMapper;

    @Value("${rapid-api.url.info.language}")
    private String getLanguageInfoURL;

    @Override
    public APIResponse<RapidAPILangInfoResponse> getLanguageInfo() throws JsonProcessingException {

        //get headers for request
        Map<String, String> headersMap = rapidAPIHeadersUtil.getHeadersForRapidAPICall();

        // make call to the third party api
        ResponseEntity<String> responseEntity = restTemplateUtil
                .makeRestCall(getLanguageInfoURL, null, headersMap, HttpMethod.GET);
        String response = responseEntity.getBody();

        if(Boolean.FALSE.equals(responseEntity.getStatusCode().is4xxClientError())
                && Boolean.FALSE.equals(responseEntity.getStatusCode().is5xxServerError())){
            RapidAPILangInfoResponse rapidAPILangInfoResponse = objectMapper.readValue(
                    response, new TypeReference<RapidAPILangInfoResponse>() {}
            );
            return APIResponse.success("fetch success", "Found articles", rapidAPILangInfoResponse);
        }
        else {
            throw new CustomException(response, "Unable to fetch", HttpStatus.FORBIDDEN);
        }
    }
}
