package app.flashnews.news_provider.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class RestTemplateUtil {

    private final RestTemplate restTemplate;

    public <T> ResponseEntity<String> makeRestCall(String uri, T requestBody, Map<String, String> headersMap, HttpMethod httpMethod) {
        HttpHeaders headers = getHeaders(headersMap);
        HttpEntity<T> entity = new HttpEntity<T>(requestBody, headers);
        log.info("RestTemplateUtil.makeRestCall, Requested an external API call with [URL={}]",uri);
        return restTemplate.exchange(uri, httpMethod, entity, String.class);
    }

    private static HttpHeaders getHeaders(Map<String, String> headersMap) {
        HttpHeaders headers = new HttpHeaders();
        if (headersMap != null) {
            for (Map.Entry<String, String> entry : headersMap.entrySet()) {
                String key = entry.getKey();
                String val = entry.getValue();
                headers.add(key, val);
            }
        }
        return headers;
    }
}
