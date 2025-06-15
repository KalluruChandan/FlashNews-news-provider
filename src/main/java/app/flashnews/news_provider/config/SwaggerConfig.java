package app.flashnews.news_provider.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("Project FlashNEWS")
                    .version("1.0")
                    .description("This Service is responsible for accessing an external News API to " +
                            "fetch news based on the search criteria coming in as a request and " +
                            "returning back the list of matching news as response."));
    }
}
