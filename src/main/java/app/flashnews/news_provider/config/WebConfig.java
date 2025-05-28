package app.flashnews.news_provider.config;

import app.flashnews.news_provider.filters.GatewayHeaderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private GatewayHeaderValidator gatewayHeaderValidator;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(gatewayHeaderValidator).addPathPatterns("/**");
    }
}
