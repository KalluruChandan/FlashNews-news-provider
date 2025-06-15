package app.flashnews.news_provider.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rapid-api.url.content")
@Data
public class ArticlesContentURLProperties {
    private String newsFeedURL;
    private String worldTrendingURL;
    private String topicSearchURL;
    private String countryNewsURL;
    private String cryptoNewsURL;
}
