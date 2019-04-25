
package model.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "w",
    "h",
    "resize"
})
public class Medium___ {

    @JsonProperty("w")
    public Integer w;
    @JsonProperty("h")
    public Integer h;
    @JsonProperty("resize")
    public String resize;

}
