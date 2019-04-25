
package model.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "created_at",
    "id",
    "id_str",
    "text",
    "truncated",
    "entities",
    "extended_entities",
    "metadata",
    "source",
    "in_reply_to_status_id",
    "in_reply_to_status_id_str",
    "in_reply_to_user_id",
    "in_reply_to_user_id_str",
    "in_reply_to_screen_name",
    "user",
    "geo",
    "coordinates",
    "place",
    "contributors",
    "is_quote_status",
    "retweet_count",
    "favorite_count",
    "favorited",
    "retweeted",
    "possibly_sensitive",
    "lang"
})
public class Example {

    @JsonProperty("created_at")
    public String createdAt;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("id_str")
    public String idStr;
    @JsonProperty("text")
    public String text;
    @JsonProperty("truncated")
    public Boolean truncated;
    @JsonProperty("entities")
    public Entities entities;
    @JsonProperty("extended_entities")
    public ExtendedEntities extendedEntities;
    @JsonProperty("metadata")
    public Metadata metadata;
    @JsonProperty("source")
    public String source;
    @JsonProperty("in_reply_to_status_id")
    public Object inReplyToStatusId;
    @JsonProperty("in_reply_to_status_id_str")
    public Object inReplyToStatusIdStr;
    @JsonProperty("in_reply_to_user_id")
    public Object inReplyToUserId;
    @JsonProperty("in_reply_to_user_id_str")
    public Object inReplyToUserIdStr;
    @JsonProperty("in_reply_to_screen_name")
    public Object inReplyToScreenName;
    @JsonProperty("user")
    public User user;
    @JsonProperty("geo")
    public Object geo;
    @JsonProperty("coordinates")
    public Object coordinates;
    @JsonProperty("place")
    public Object place;
    @JsonProperty("contributors")
    public Object contributors;
    @JsonProperty("is_quote_status")
    public Boolean isQuoteStatus;
    @JsonProperty("retweet_count")
    public Integer retweetCount;
    @JsonProperty("favorite_count")
    public Integer favoriteCount;
    @JsonProperty("favorited")
    public Boolean favorited;
    @JsonProperty("retweeted")
    public Boolean retweeted;
    @JsonProperty("possibly_sensitive")
    public Boolean possiblySensitive;
    @JsonProperty("lang")
    public String lang;

}
