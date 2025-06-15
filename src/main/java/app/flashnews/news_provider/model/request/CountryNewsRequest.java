package app.flashnews.news_provider.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryNewsRequest {

    private Integer skip;
    private Integer batchSize;
    @NotNull(message = "fromCountry cannot be null")
    @NotEmpty(message = "fromCountry cannot be empty")
    private String fromCountry;
    private String languages;
    private Boolean onlyInternational = Boolean.TRUE;
    private String aboutCountry;

    public void setLanguages(List<String> languages){
        if(languages != null && languages.isEmpty()){
            this.languages = null;
        }
        else {
            this.languages = String.join(",",languages);
        }
    }

}
