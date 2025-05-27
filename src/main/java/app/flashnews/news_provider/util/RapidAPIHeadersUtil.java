package app.flashnews.news_provider.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RapidAPIHeadersUtil {

    @Value("${rapid-api.hostname}")
    private String hostName;

    @Value("${rapid-api.apikey}")
    private String apiKey;

    public Map<String,String> getHeadersForRapidAPICall(){
        Map<String,String> headersMap = new HashMap<>();
        headersMap.put("x-rapidapi-key", apiKey);
        headersMap.put("x-rapidapi-host", hostName);
        return headersMap;
    }
}
