
package model.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "id_str",
    "name",
    "screen_name",
    "location",
    "description",
    "url",
    "entities",
    "protected",
    "followers_count",
    "friends_count",
    "listed_count",
    "created_at",
    "favourites_count",
    "utc_offset",
    "time_zone",
    "geo_enabled",
    "verified",
    "statuses_count",
    "lang",
    "contributors_enabled",
    "is_translator",
    "is_translation_enabled",
    "profile_background_color",
    "profile_background_image_url",
    "profile_background_image_url_https",
    "profile_background_tile",
    "profile_image_url",
    "profile_image_url_https",
    "profile_link_color",
    "profile_sidebar_border_color",
    "profile_sidebar_fill_color",
    "profile_text_color",
    "profile_use_background_image",
    "has_extended_profile",
    "default_profile",
    "default_profile_image",
    "following",
    "follow_request_sent",
    "notifications",
    "translator_type"
})
public class User {

    @JsonProperty("id")
    public Long id;
    @JsonProperty("id_str")
    public String idStr;
    @JsonProperty("name")
    public String name;
    @JsonProperty("screen_name")
    public String screenName;
    @JsonProperty("location")
    public String location;
    @JsonProperty("description")
    public String description;
    @JsonProperty("url")
    public String url;
    @JsonProperty("entities")
    public Entities_ entities;
    @JsonProperty("protected")
    public Boolean _protected;
    @JsonProperty("followers_count")
    public Long followersCount;
    @JsonProperty("friends_count")
    public Long friendsCount;
    @JsonProperty("listed_count")
    public Long listedCount;
    @JsonProperty("created_at")
    public String createdAt;
    @JsonProperty("favourites_count")
    public Integer favouritesCount;
    @JsonProperty("utc_offset")
    public Object utcOffset;
    @JsonProperty("time_zone")
    public Object timeZone;
    @JsonProperty("geo_enabled")
    public Boolean geoEnabled;
    @JsonProperty("verified")
    public Boolean verified;
    @JsonProperty("statuses_count")
    public Integer statusesCount;
    @JsonProperty("lang")
    public String lang;
    @JsonProperty("contributors_enabled")
    public Boolean contributorsEnabled;
    @JsonProperty("is_translator")
    public Boolean isTranslator;
    @JsonProperty("is_translation_enabled")
    public Boolean isTranslationEnabled;
    @JsonProperty("profile_background_color")
    public String profileBackgroundColor;
    @JsonProperty("profile_background_image_url")
    public String profileBackgroundImageUrl;
    @JsonProperty("profile_background_image_url_https")
    public String profileBackgroundImageUrlHttps;
    @JsonProperty("profile_background_tile")
    public Boolean profileBackgroundTile;
    @JsonProperty("profile_image_url")
    public String profileImageUrl;
    @JsonProperty("profile_image_url_https")
    public String profileImageUrlHttps;
    @JsonProperty("profile_link_color")
    public String profileLinkColor;
    @JsonProperty("profile_sidebar_border_color")
    public String profileSidebarBorderColor;
    @JsonProperty("profile_sidebar_fill_color")
    public String profileSidebarFillColor;
    @JsonProperty("profile_text_color")
    public String profileTextColor;
    @JsonProperty("profile_use_background_image")
    public Boolean profileUseBackgroundImage;
    @JsonProperty("has_extended_profile")
    public Boolean hasExtendedProfile;
    @JsonProperty("default_profile")
    public Boolean defaultProfile;
    @JsonProperty("default_profile_image")
    public Boolean defaultProfileImage;
    @JsonProperty("following")
    public Boolean following;
    @JsonProperty("follow_request_sent")
    public Boolean followRequestSent;
    @JsonProperty("notifications")
    public Boolean notifications;
    @JsonProperty("translator_type")
    public String translatorType;

}
