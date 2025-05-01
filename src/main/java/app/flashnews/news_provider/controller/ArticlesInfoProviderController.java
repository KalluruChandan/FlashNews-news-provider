package app.flashnews.news_provider.controller;

import app.flashnews.news_provider.model.response.APIResponse;
import app.flashnews.news_provider.service.ArticlesInfoProviderService;
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
    public ResponseEntity<APIResponse<String>> getLanguageInfo(){
        return ResponseEntity.ok(articlesInfoProviderService.getLanguageInfo());
    }

}
