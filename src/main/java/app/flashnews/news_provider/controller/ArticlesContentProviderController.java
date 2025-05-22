package app.flashnews.news_provider.controller;

import app.flashnews.news_provider.model.request.NewsFeedRequest;
import app.flashnews.news_provider.model.response.APIResponse;
import app.flashnews.news_provider.model.response.NewsApiResponse;
import app.flashnews.news_provider.service.ArticlesContentProviderService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
}
