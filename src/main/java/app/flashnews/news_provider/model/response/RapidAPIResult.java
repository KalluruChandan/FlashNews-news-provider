package app.flashnews.news_provider.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RapidAPIResult {

    private String response;
    private Long newsCount;
    private Long skipped;
}
