
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
public class Medium_ {

    @JsonProperty("w")
    public Long w;
    @JsonProperty("h")
    public Long h;
    @JsonProperty("resize")
    public String resize;

}
