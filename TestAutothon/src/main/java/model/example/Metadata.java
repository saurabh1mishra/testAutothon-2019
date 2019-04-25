
package model.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Metadata {
    @JsonProperty("iso_language_code")
    String iso_language_code;
    @JsonProperty("result_type")

    String result_type;
}
