package app.flashnews.news_provider.service.impl;

import app.flashnews.news_provider.model.response.APIResponse;
import app.flashnews.news_provider.service.ArticlesInfoProviderService;
import app.flashnews.news_provider.util.RapidAPIHeadersUtil;
import app.flashnews.news_provider.util.RestTemplateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticlesInfoProviderServiceImpl implements ArticlesInfoProviderService {

    private final RestTemplateUtil restTemplateUtil;
    private final RapidAPIHeadersUtil rapidAPIHeadersUtil;

    @Value("${rapid-api.url.info.language}")
    private String getLanguageInfoURL;

    @Override
    public APIResponse<String> getLanguageInfo() {

        // make call to the third party api
        Map<String, String> headersMap = rapidAPIHeadersUtil.getHeadersForRapidAPICall();

        ResponseEntity<String> responseEntity = restTemplateUtil
                .makeRestCall(getLanguageInfoURL, null, headersMap, HttpMethod.GET);
        String response = responseEntity.getBody();
        return APIResponse.success("fetch success", "Found articles", response);
    }
}
