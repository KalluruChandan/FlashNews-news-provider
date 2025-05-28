package app.flashnews.news_provider.filters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class GatewayHeaderValidator implements HandlerInterceptor {

    @Value("${api.access.key}")
    private String expectedKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        String gatewayKey = request.getHeader("X-GATEWAY-KEY");

        if (!expectedKey.equals(gatewayKey)) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write("Access denied. Requests must come through API Gateway.");
            return false;
        }
        return true;
    }
}
