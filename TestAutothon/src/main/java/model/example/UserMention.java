
package model.example;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "screen_name",
    "name",
    "id",
    "id_str",
    "indices"
})
public class UserMention {

    @JsonProperty("screen_name")
    public String screenName;
    @JsonProperty("name")
    public String name;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("id_str")
    public String idStr;
    @JsonProperty("indices")
    public List<Integer> indices = null;

}
