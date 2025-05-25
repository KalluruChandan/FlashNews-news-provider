package app.flashnews.news_provider.service;

import app.flashnews.news_provider.model.request.*;
import app.flashnews.news_provider.model.response.APIResponse;
import app.flashnews.news_provider.model.response.NewsApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface ArticlesContentProviderService {
    APIResponse<NewsApiResponse> getNewsFeed(NewsFeedRequest newsFeedRequest) throws JsonProcessingException;

    APIResponse<NewsApiResponse> getWorldTrendingFeed(WorldTrendingFeedRequest worldTrendingFeedRequest) throws JsonProcessingException;

    APIResponse<NewsApiResponse> getCountryNewsFeed(CountryNewsRequest countryNewsRequest) throws JsonProcessingException;

    APIResponse<NewsApiResponse> getTopicSearchFeed(TopicSearchFeedRequest topicSearchFeedRequest) throws JsonProcessingException;

    APIResponse<NewsApiResponse> getCryptoNewsFeed(CryptoNewsFeedRequest cryptoNewsFeedRequest) throws JsonProcessingException;
}
