package app.flashnews.news_provider.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldTrendingFeedRequest {
    private Integer relatedNewsLimit;
    private String languages;
    private String top;
    private String skip;

    public void setLanguages(List<String> languages){
        if(languages != null && languages.isEmpty()){
            this.languages = null;
        }
        else {
            this.languages = String.join(",",languages);
        }
    }
}
