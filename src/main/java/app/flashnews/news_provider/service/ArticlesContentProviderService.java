package app.flashnews.news_provider.service;

import app.flashnews.news_provider.model.request.NewsFeedRequest;
import app.flashnews.news_provider.model.response.APIResponse;
import app.flashnews.news_provider.model.response.NewsApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface ArticlesContentProviderService {
    APIResponse<NewsApiResponse> getNewsFeed(NewsFeedRequest newsFeedRequest) throws JsonProcessingException;
}
