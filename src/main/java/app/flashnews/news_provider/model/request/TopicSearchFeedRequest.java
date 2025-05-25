package app.flashnews.news_provider.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicSearchFeedRequest {

    private String batchSize;
    private Integer skip;
    private String searchType;
    @NotNull(message = "Languages cannot be null")
    @NotEmpty(message = "Languages cannot be empty")
    @JsonProperty("languages")
    private String languages;
    private String qField;
    private String sortBy;
    @NotNull(message = "search cannot be null")
    @NotEmpty(message = "search cannot be empty")
    private String search;
    private String publishedAfter;
    private String publishedBefore;

    public void setLanguages(List<String> languages){
        if(languages != null && languages.isEmpty()){
            this.languages = null;
        }
        else {
            this.languages = String.join(",",languages);
        }
    }
}
