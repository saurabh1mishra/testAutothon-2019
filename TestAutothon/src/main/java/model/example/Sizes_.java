
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
public class Sizes_ {

    @JsonProperty("thumb")
    public Thumb_ thumb;
    @JsonProperty("medium")
    public Medium___ medium;
    @JsonProperty("small")
    public Small_ small;
    @JsonProperty("large")
    public Large_ large;

}
