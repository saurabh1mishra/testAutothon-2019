
package model.example;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Medium {

    @JsonProperty("id")
    public Long id;
    @JsonProperty("id_str")
    public String idStr;
    @JsonProperty("indices")
    public List<Integer> indices = null;
    @JsonProperty("media_url")
    public String mediaUrl;
    @JsonProperty("media_url_https")
    public String mediaUrlHttps;
    @JsonProperty("url")
    public String url;
    @JsonProperty("display_url")
    public String displayUrl;
    @JsonProperty("expanded_url")
    public String expandedUrl;
    @JsonProperty("type")
    public String type;
    @JsonProperty("sizes")
    public Sizes sizes;

}
