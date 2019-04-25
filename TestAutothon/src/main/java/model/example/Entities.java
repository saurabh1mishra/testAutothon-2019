
package model.example;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Entities {

    @JsonProperty("hashtags")
    public List<Hashtag> hashtags = null;
    @JsonProperty("symbols")
    public List<Object> symbols = null;
    @JsonProperty("user_mentions")
    public List<UserMention> userMentions = null;
    @JsonProperty("urls")
    public List<Object> urls = null;
    @JsonProperty("media")
    public List<Medium> media = null;

}
