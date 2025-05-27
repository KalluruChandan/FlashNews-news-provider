package app.flashnews.news_provider.controller;

import app.flashnews.news_provider.model.response.APIResponse;
import app.flashnews.news_provider.model.response.RapidAPICategoryInfoResponse;
import app.flashnews.news_provider.model.response.RapidAPICountriesInfoResponse;
import app.flashnews.news_provider.model.response.RapidAPILangInfoResponse;
import app.flashnews.news_provider.service.ArticlesInfoProviderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Info Provider", description = "APIs to retrieve language, category, and country metadata for articles")
@RestController
@RequestMapping("/v1/api/info")
@Slf4j
@RequiredArgsConstructor
public class ArticlesInfoProviderController {

    private final ArticlesInfoProviderService articlesInfoProviderService;

    @Operation(
            summary = "Get supported languages",
            description = "Fetches the list of supported languages from the news provider.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Languages retrieved successfully",
                            content = @Content(schema = @Schema(implementation = RapidAPILangInfoResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/language")
    public ResponseEntity<APIResponse<RapidAPILangInfoResponse>> getLanguageInfo() throws JsonProcessingException {
        return ResponseEntity.ok(articlesInfoProviderService.getLanguageInfo());
    }

    @Operation(
            summary = "Get article categories",
            description = "Fetches the available categories for filtering news content.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Categories retrieved successfully",
                            content = @Content(schema = @Schema(implementation = RapidAPICategoryInfoResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/categories")
    public ResponseEntity<APIResponse<RapidAPICategoryInfoResponse>> getCategoriesInfo() throws JsonProcessingException {
        return ResponseEntity.ok(articlesInfoProviderService.getCategoriesInfo());
    }

    @Operation(
            summary = "Get supported countries",
            description = "Fetches the list of supported countries for region-specific news.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Countries retrieved successfully",
                            content = @Content(schema = @Schema(implementation = RapidAPICountriesInfoResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/countries")
    public ResponseEntity<APIResponse<RapidAPICountriesInfoResponse>> getCountriesInfo() throws JsonProcessingException {
        return ResponseEntity.ok(articlesInfoProviderService.getCountriesInfo());
    }
}
