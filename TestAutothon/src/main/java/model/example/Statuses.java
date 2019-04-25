
package model.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Statuses {



    public Object contributors;
    @JsonProperty("is_quote_status")
    public Boolean isQuoteStatus;
    @JsonProperty("retweet_count")
    public Integer retweetCount;
    @JsonProperty("favorite_count")
    public Integer favoriteCount;
    @JsonProperty("favorited")
    public Boolean favorited;
    @JsonProperty("retweeted")
    public Boolean retweeted;
}
