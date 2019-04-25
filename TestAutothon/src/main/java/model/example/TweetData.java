package model.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TweetData {
    @JsonProperty("statuses")
    List<Statuses> tweetdata;
}
