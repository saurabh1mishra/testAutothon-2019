
package model.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "thumb",
    "medium",
    "small",
    "large"
})
public class Sizes {

    @JsonProperty("thumb")
    public Thumb thumb;
    @JsonProperty("medium")
    public Medium_ medium;
    @JsonProperty("small")
    public Small small;
    @JsonProperty("large")
    public Large large;

}
