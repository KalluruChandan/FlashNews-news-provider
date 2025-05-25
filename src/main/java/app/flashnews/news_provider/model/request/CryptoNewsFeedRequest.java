package app.flashnews.news_provider.model.request;

import app.flashnews.news_provider.model.enumeration.Sentiment;
import app.flashnews.news_provider.model.enumeration.SortOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoNewsFeedRequest {

    private String languages;
    private Sentiment sentiment;
    private SortOrder sortOrder;
    private Integer batchSize;
    private Integer skip;
}
