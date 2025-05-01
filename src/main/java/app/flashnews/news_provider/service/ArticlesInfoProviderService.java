package app.flashnews.news_provider.service;

import app.flashnews.news_provider.model.response.APIResponse;

public interface ArticlesInfoProviderService {
    APIResponse<String> getLanguageInfo();
}
