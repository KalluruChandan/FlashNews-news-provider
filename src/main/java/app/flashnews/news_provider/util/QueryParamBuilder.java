package app.flashnews.news_provider.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

public class QueryParamBuilder {

    public static String buildQueryParams(Object obj) {
        if (obj == null) {
            return "";
        }

        StringJoiner queryParams = new StringJoiner("&", "?", "");
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (value != null) {
                    String encodedName = URLEncoder.encode(field.getName(), StandardCharsets.UTF_8);
                    String encodedValue = URLEncoder.encode(value.toString(), StandardCharsets.UTF_8);
                    queryParams.add(encodedName + "=" + encodedValue);
                }
            } catch (IllegalAccessException e) {
                // You may want to log this exception or rethrow it as a runtime exception
                throw new RuntimeException("Failed to access field: " + field.getName(), e);
            }
        }

        String result = queryParams.toString();
        return result.equals("?") ? "" : result;  // Return empty string if no non-null fields
    }
}
