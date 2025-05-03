package app.flashnews.news_provider.service;

import app.flashnews.news_provider.model.response.APIResponse;
import app.flashnews.news_provider.model.response.RapidAPILangInfoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ArticlesInfoProviderService {
    APIResponse<RapidAPILangInfoResponse> getLanguageInfo() throws JsonProcessingException;
}
