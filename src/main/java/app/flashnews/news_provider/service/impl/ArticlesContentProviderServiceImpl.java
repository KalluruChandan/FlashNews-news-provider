package app.flashnews.news_provider.service.impl;

import app.flashnews.news_provider.exception.CustomException;
import app.flashnews.news_provider.model.request.*;
import app.flashnews.news_provider.model.response.APIResponse;
import app.flashnews.news_provider.model.response.NewsApiResponse;
import app.flashnews.news_provider.model.response.RapidAPICountriesInfoResponse;
import app.flashnews.news_provider.properties.ArticlesContentURLProperties;
import app.flashnews.news_provider.service.ArticlesContentProviderService;
import app.flashnews.news_provider.util.QueryParamBuilder;
import app.flashnews.news_provider.util.RapidAPIHeadersUtil;
import app.flashnews.news_provider.util.RestTemplateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ArticlesContentProviderServiceImpl implements ArticlesContentProviderService {

    private final RestTemplateUtil restTemplateUtil;
    private final RapidAPIHeadersUtil rapidAPIHeadersUtil;
    private final ObjectMapper objectMapper;
    private final ArticlesContentURLProperties articlesContentURLProperties;

    @Override
    public APIResponse<NewsApiResponse> getNewsFeed(NewsFeedRequest newsFeedRequest) throws JsonProcessingException {
        //get headers for request
        Map<String, String> headersMap = rapidAPIHeadersUtil.getHeadersForRapidAPICall();

        //build request param based on newsFeedRequest
        String queryParams = QueryParamBuilder.buildQueryParams(newsFeedRequest);

        // make call to the third party api
        ResponseEntity<String> responseEntity = restTemplateUtil
                .makeRestCall(articlesContentURLProperties.getNewsFeedURL() + queryParams, null, headersMap, HttpMethod.GET);
        String response = responseEntity.getBody();

        if(Boolean.FALSE.equals(responseEntity.getStatusCode().is4xxClientError())
                && Boolean.FALSE.equals(responseEntity.getStatusCode().is5xxServerError())){
            NewsApiResponse rapidAPINEWSFeedContentResponse = objectMapper.readValue(
                    response, new TypeReference<NewsApiResponse>() {}
            );
            return APIResponse.success("fetch success", "Articles Found", rapidAPINEWSFeedContentResponse);
        }
        else {
            throw new CustomException(response, "Unable to fetch", HttpStatus.valueOf(responseEntity.getStatusCode().value()));
        }
    }

    @Override
    public APIResponse<NewsApiResponse> getWorldTrendingFeed(WorldTrendingFeedRequest worldTrendingFeedRequest) throws JsonProcessingException {
        //get headers for request
        Map<String, String> headersMap = rapidAPIHeadersUtil.getHeadersForRapidAPICall();

        //build request param based on newsFeedRequest
        String queryParams = QueryParamBuilder.buildQueryParams(worldTrendingFeedRequest);

        // make call to the third party api
        ResponseEntity<String> responseEntity = restTemplateUtil
                .makeRestCall(articlesContentURLProperties.getWorldTrendingURL() + queryParams, null, headersMap, HttpMethod.GET);
        String response = responseEntity.getBody();

        if(Boolean.FALSE.equals(responseEntity.getStatusCode().is4xxClientError())
                && Boolean.FALSE.equals(responseEntity.getStatusCode().is5xxServerError())){
            NewsApiResponse rapidAPINEWSFeedContentResponse = objectMapper.readValue(
                    response, new TypeReference<NewsApiResponse>() {}
            );
            return APIResponse.success("fetch success", "Articles Found", rapidAPINEWSFeedContentResponse);
        }
        else {
            throw new CustomException(response, "Unable to fetch", HttpStatus.valueOf(responseEntity.getStatusCode().value()));
        }
    }

    @Override
    public APIResponse<NewsApiResponse> getCountryNewsFeed(CountryNewsRequest countryNewsRequest) throws JsonProcessingException {
        //get headers for request
        Map<String, String> headersMap = rapidAPIHeadersUtil.getHeadersForRapidAPICall();

        //build request param based on newsFeedRequest
        String queryParams = QueryParamBuilder.buildQueryParams(countryNewsRequest);

        // make call to the third party api
        ResponseEntity<String> responseEntity = restTemplateUtil
                .makeRestCall(articlesContentURLProperties.getCountryNewsURL() + queryParams, null, headersMap, HttpMethod.GET);
        String response = responseEntity.getBody();

        if(Boolean.FALSE.equals(responseEntity.getStatusCode().is4xxClientError())
                && Boolean.FALSE.equals(responseEntity.getStatusCode().is5xxServerError())){
            NewsApiResponse rapidAPINEWSFeedContentResponse = objectMapper.readValue(
                    response, new TypeReference<NewsApiResponse>() {}
            );
            return APIResponse.success("fetch success", "Articles Found", rapidAPINEWSFeedContentResponse);
        }
        else {
            throw new CustomException(response, "Unable to fetch", HttpStatus.valueOf(responseEntity.getStatusCode().value()));
        }
    }

    @Override
    public APIResponse<NewsApiResponse> getTopicSearchFeed(TopicSearchFeedRequest topicSearchFeedRequest) throws JsonProcessingException {
        //get headers for request
        Map<String, String> headersMap = rapidAPIHeadersUtil.getHeadersForRapidAPICall();

        //build request param based on newsFeedRequest
        String queryParams = QueryParamBuilder.buildQueryParams(topicSearchFeedRequest);

        // make call to the third party api
        ResponseEntity<String> responseEntity = restTemplateUtil
                .makeRestCall(articlesContentURLProperties.getTopicSearchURL() + queryParams, null, headersMap, HttpMethod.GET);
        String response = responseEntity.getBody();

        if(Boolean.FALSE.equals(responseEntity.getStatusCode().is4xxClientError())
                && Boolean.FALSE.equals(responseEntity.getStatusCode().is5xxServerError())){
            NewsApiResponse rapidAPINEWSFeedContentResponse = objectMapper.readValue(
                    response, new TypeReference<NewsApiResponse>() {}
            );
            return APIResponse.success("fetch success", "Articles Found", rapidAPINEWSFeedContentResponse);
        }
        else {
            throw new CustomException(response, "Unable to fetch", HttpStatus.valueOf(responseEntity.getStatusCode().value()));
        }
    }

    @Override
    public APIResponse<NewsApiResponse> getCryptoNewsFeed(CryptoNewsFeedRequest cryptoNewsFeedRequest) throws JsonProcessingException {
        //get headers for request
        Map<String, String> headersMap = rapidAPIHeadersUtil.getHeadersForRapidAPICall();

        //build request param based on newsFeedRequest
        String queryParams = QueryParamBuilder.buildQueryParams(cryptoNewsFeedRequest);

        // make call to the third party api
        ResponseEntity<String> responseEntity = restTemplateUtil
                .makeRestCall(articlesContentURLProperties.getCryptoNewsURL() + queryParams, null, headersMap, HttpMethod.GET);
        String response = responseEntity.getBody();

        if(Boolean.FALSE.equals(responseEntity.getStatusCode().is4xxClientError())
                && Boolean.FALSE.equals(responseEntity.getStatusCode().is5xxServerError())){
            NewsApiResponse rapidAPINEWSFeedContentResponse = objectMapper.readValue(
                    response, new TypeReference<NewsApiResponse>() {}
            );
            return APIResponse.success("fetch success", "Articles Found", rapidAPINEWSFeedContentResponse);
        }
        else {
            throw new CustomException(response, "Unable to fetch", HttpStatus.valueOf(responseEntity.getStatusCode().value()));
        }
    }
}
