package app.flashnews.news_provider.controller;

import app.flashnews.news_provider.model.response.APIResponse;
import app.flashnews.news_provider.model.response.RapidAPICategoryInfoResponse;
import app.flashnews.news_provider.model.response.RapidAPICountriesInfoResponse;
import app.flashnews.news_provider.model.response.RapidAPILangInfoResponse;
import app.flashnews.news_provider.service.ArticlesInfoProviderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/info")
@Slf4j
@RequiredArgsConstructor
public class ArticlesInfoProviderController {

    private final ArticlesInfoProviderService articlesInfoProviderService;

    @GetMapping("/language")
    public ResponseEntity<APIResponse<RapidAPILangInfoResponse>> getLanguageInfo() throws JsonProcessingException {
        return ResponseEntity.ok(articlesInfoProviderService.getLanguageInfo());
    }

    @GetMapping("/categories")
    public ResponseEntity<APIResponse<RapidAPICategoryInfoResponse>> getCategoriesInfo() throws JsonProcessingException {
        return ResponseEntity.ok(articlesInfoProviderService.getCategoriesInfo());
    }

    @GetMapping("/countries")
    public ResponseEntity<APIResponse<RapidAPICountriesInfoResponse>> getCountriesInfo() throws JsonProcessingException {
        return ResponseEntity.ok(articlesInfoProviderService.getCountriesInfo());
    }
}
