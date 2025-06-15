package app.flashnews.news_provider.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {
    @JsonProperty("label")
    private String label;

    @JsonProperty("IPTCCode")
    private String iptcCode;
}
