package app.flashnews.news_provider.controller;

import app.flashnews.news_provider.model.request.*;
import app.flashnews.news_provider.model.response.APIResponse;
import app.flashnews.news_provider.model.response.NewsApiResponse;
import app.flashnews.news_provider.service.ArticlesContentProviderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Content Provider", description = "APIs for fetching various types of news feeds")
@RestController
@RequestMapping("/v1/api/content")
@RequiredArgsConstructor
public class ArticlesContentProviderController {

    private final ArticlesContentProviderService articlesContentProviderService;

    @Operation(
            summary = "Fetch news feed",
            description = "Fetches general news feed based on the provided parameters.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response",
                            content = @Content(schema = @Schema(implementation = NewsApiResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PostMapping("/news-feed")
    public ResponseEntity<APIResponse<NewsApiResponse>> getNewsFeed(@RequestBody NewsFeedRequest newsFeedRequest) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(articlesContentProviderService.getNewsFeed(newsFeedRequest));
    }

    @Operation(
            summary = "Fetch world trending news",
            description = "Returns trending news headlines from around the world.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response",
                            content = @Content(schema = @Schema(implementation = NewsApiResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PostMapping("/world-trending")
    public ResponseEntity<APIResponse<NewsApiResponse>> getWorldTrendingFeed(@RequestBody WorldTrendingFeedRequest worldTrendingFeedRequest) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(articlesContentProviderService.getWorldTrendingFeed(worldTrendingFeedRequest));
    }

    @Operation(
            summary = "Fetch country-specific news",
            description = "Fetches news headlines specific to a given country.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response",
                            content = @Content(schema = @Schema(implementation = NewsApiResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid or missing country data"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PostMapping("/country-news")
    public ResponseEntity<APIResponse<NewsApiResponse>> getCountryNewsFeed(@Valid @RequestBody CountryNewsRequest countryNewsRequest) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(articlesContentProviderService.getCountryNewsFeed(countryNewsRequest));
    }

    @Operation(
            summary = "Search news by topic",
            description = "Returns news articles based on a topic keyword search.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response",
                            content = @Content(schema = @Schema(implementation = NewsApiResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid topic or parameters"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PostMapping("/topic-search")
    public ResponseEntity<APIResponse<NewsApiResponse>> getTopicSearchFeed(@Valid @RequestBody TopicSearchFeedRequest topicSearchFeedRequest) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(articlesContentProviderService.getTopicSearchFeed(topicSearchFeedRequest));
    }

    @Operation(
            summary = "Fetch crypto news",
            description = "Fetches latest news headlines related to cryptocurrencies.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response",
                            content = @Content(schema = @Schema(implementation = NewsApiResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid parameters"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PostMapping("/crypto-news")
    public ResponseEntity<APIResponse<NewsApiResponse>> getCryptoNewsFeed(@RequestBody CryptoNewsFeedRequest cryptoNewsFeedRequest) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(articlesContentProviderService.getCryptoNewsFeed(cryptoNewsFeedRequest));
    }

}
