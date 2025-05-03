package app.flashnews.news_provider.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RapidAPILangInfoResponse {

    @JsonProperty("Languages")
    private List<LanguageInfo> languageInfoList;
}
