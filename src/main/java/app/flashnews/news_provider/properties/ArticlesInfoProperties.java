package app.flashnews.news_provider.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rapid-api.url.info")
@Data
public class ArticlesInfoProperties {

    private String languageURL;
    private String categoriesURL;
    private String countriesURL;
}
