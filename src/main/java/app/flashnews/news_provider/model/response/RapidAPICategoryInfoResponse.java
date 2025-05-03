package app.flashnews.news_provider.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RapidAPICategoryInfoResponse {

    @JsonProperty("result")
    private RapidAPIResult rapidAPIResult;

    @JsonProperty("categories")
    private List<CategoriesInfo> categoriesInfoList;
}
