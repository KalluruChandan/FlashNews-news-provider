package app.flashnews.news_provider.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    public void setLanguages(List<String> languages){
        if(languages != null && languages.isEmpty()){
            this.languages = null;
        }
        else {
            this.languages = String.join(",",languages);
        }
    }
}
