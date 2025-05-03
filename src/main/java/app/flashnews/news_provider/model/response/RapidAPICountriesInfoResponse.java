package app.flashnews.news_provider.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RapidAPICountriesInfoResponse {

    @JsonProperty("CountryCodes")
    private List<String> countryCodes;
}
