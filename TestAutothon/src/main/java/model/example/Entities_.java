
package model.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "description"
})
public class Entities_ {

    @JsonProperty("url")
    public Url url;
    @JsonProperty("description")
    public Description description;

}
