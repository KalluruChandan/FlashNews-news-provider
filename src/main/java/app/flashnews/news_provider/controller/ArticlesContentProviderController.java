package app.flashnews.news_provider.controller;

import app.flashnews.news_provider.model.request.*;
import app.flashnews.news_provider.model.response.APIResponse;
import app.flashnews.news_provider.model.response.NewsApiResponse;
import app.flashnews.news_provider.service.ArticlesContentProviderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/content")
@RequiredArgsConstructor
public class ArticlesContentProviderController {

    private final ArticlesContentProviderService articlesContentProviderService;

    @PostMapping("/news-feed")
    public ResponseEntity<APIResponse<NewsApiResponse>> getNewsFeed(@RequestBody NewsFeedRequest newsFeedRequest) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(articlesContentProviderService.getNewsFeed(newsFeedRequest));
    }

    @PostMapping("/world-trending")
    public ResponseEntity<APIResponse<NewsApiResponse>> getWorldTrendingFeed(@RequestBody WorldTrendingFeedRequest worldTrendingFeedRequest) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(articlesContentProviderService.getWorldTrendingFeed(worldTrendingFeedRequest));
    }

    @PostMapping("/country-news")
    public ResponseEntity<APIResponse<NewsApiResponse>> getCountryNewsFeed(@Valid @RequestBody CountryNewsRequest countryNewsRequest) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(articlesContentProviderService.getCountryNewsFeed(countryNewsRequest));
    }

    @PostMapping("/topic-search")
    public ResponseEntity<APIResponse<NewsApiResponse>> getTopicSearchFeed(@Valid @RequestBody TopicSearchFeedRequest topicSearchFeedRequest) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(articlesContentProviderService.getTopicSearchFeed(topicSearchFeedRequest));
    }

    @PostMapping("/crypto-news")
    public ResponseEntity<APIResponse<NewsApiResponse>> getCryptoNewsFeed(@RequestBody CryptoNewsFeedRequest cryptoNewsFeedRequest) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(articlesContentProviderService.getCryptoNewsFeed(cryptoNewsFeedRequest));
    }

}
