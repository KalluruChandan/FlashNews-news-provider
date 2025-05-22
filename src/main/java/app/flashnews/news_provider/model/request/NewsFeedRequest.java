package app.flashnews.news_provider.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsFeedRequest {
    private String categoryCode;
    private Integer batchSize;
    private String languages;
    private String sortOrder;
    private String sources;
    private String sentiment;
    private Integer skip;
}
